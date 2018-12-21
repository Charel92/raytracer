package main.java.de.unitrier.st.ueb3;

public class Ray {
    Vec3D start=new Vec3D(0,0,0);
    Vec3D dir=new Vec3D(0,0,0);

    void setStart(float x, float y, float z) { start=new Vec3D(x,y,z); }
    void setDir(float dx, float dy, float dz) { dir=new Vec3D(dx, dy, dz); }
    void normalize() {  dir.normalize(); }

    // see M�ller&Haines, page 305
    IPoint intersect(Triangle t)
    { float epsilon=IPoint.epsilon;
        Vec3D e1 = t.p2.minus(t.p1);
        Vec3D e2 = t.p3.minus(t.p1);
        Vec3D p =  dir.cross(e2);
        float a = e1.dot(p);
        if ((a>-epsilon) && (a<epsilon)) return new IPoint(null,null,-1);
        float f = 1/a;
        Vec3D s = start.minus(t.p1);
        float u = f*s.dot(p);
        if ((u<0.0) || (u>1.0)) return new IPoint(null,null,-1);
        Vec3D q = s.cross(e1);
        float v = f*dir.dot(q);
        if ((v<0.0) || (u+v>1.0)) return new IPoint(null,null,-1);
        // intersection point is u,v
        float dist=f*e2.dot(q);
        if (dist<epsilon) return new IPoint(null,null,-1);
        Vec3D ip=t.p1.mult(1-u-v).add(t.p2.mult(u)).add(t.p3.mult(v));
        //DEBUG.debug("Intersection point: "+ip.x+","+ip.y+","+ip.z);
        return new IPoint(t,ip,dist);
    }
}
