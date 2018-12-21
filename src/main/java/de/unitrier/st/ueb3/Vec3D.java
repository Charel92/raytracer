package main.java.de.unitrier.st.ueb3;

public class Vec3D {
    float x, y, z, w=1;
    Vec3D(float xx, float yy, float zz) { x=xx; y=yy; z=zz; }
    Vec3D(float xx, float yy, float zz, float ww) { x=xx; y=yy; z=zz; w=ww; }
    Vec3D add(Vec3D v)
    { return new Vec3D(x+v.x, y+v.y, z+v.z); }
    Vec3D minus(Vec3D v)
    { return new Vec3D(x-v.x, y-v.y, z-v.z); }
    Vec3D mult(float a)
    { return new Vec3D(a*x, a*y, a*z); }

    void normalize()
    {  float dist = (float) Math.sqrt( (x * x)+(y * y)+(z * z) );
        x = x / dist;
        y = y / dist;
        z = z / dist;
    }

    float dot(Vec3D v) { return x*v.x+y*v.y+z*v.z; }

    Vec3D cross(Vec3D v) {
        return new Vec3D( y*v.z-z*v.y, z*v.x-x*v.z, x*v.y-y*v.x);
    }
}
