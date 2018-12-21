package main.java.de.unitrier.st.ueb3;

import java.util.List;

public class Cube {
    public static void addCube(List<Triangle> triangles, int x, int y, int z, int w, int h, int d, RGB c, float sh)
    {  //front
        triangles.add(new Triangle(new Vec3D(x,y,z), new Vec3D(x+w,y,z), new Vec3D(x,y+h,z), c, sh));
        triangles.add(new Triangle(new Vec3D(x+w,y,z), new Vec3D(x+w,y+h,z), new Vec3D(x,y+h,z), c, sh));
        //left
        triangles.add(new Triangle(new Vec3D(x,y,z+d), new Vec3D(x,y,z), new Vec3D(x,y+h,z), c, sh));
        triangles.add(new Triangle(new Vec3D(x,y+h,z), new Vec3D(x,y+h,z+d), new Vec3D(x,y,z+d), c, sh));
        //right
        triangles.add(new Triangle(new Vec3D(x+w,y,z), new Vec3D(x+w,y,z+d), new Vec3D(x+w,y+h,z), c, sh));
        triangles.add(new Triangle(new Vec3D(x+w,y+h,z), new Vec3D(x+w,y,z+d), new Vec3D(x+w,y+h,z+d), c, sh));
        //top
        triangles.add(new Triangle(new Vec3D(x+w,y+h,z), new Vec3D(x+w,y+h,z+d), new Vec3D(x,y+h,z), c, sh));
        triangles.add(new Triangle(new Vec3D(x,y+h,z), new Vec3D(x+w,y+h,z+d), new Vec3D(x,y+h,z+d), c, sh));
        //bottom
        triangles.add(new Triangle(new Vec3D(x+w,y,z), new Vec3D(x,y,z), new Vec3D(x,y,z+d), c, sh));
        triangles.add(new Triangle(new Vec3D(x,y,z+d), new Vec3D(x+w,y,z+d), new Vec3D(x+w,y,z), c, sh));
        //back
        triangles.add(new Triangle(new Vec3D(x,y,z+d),  new Vec3D(x,y+h,z+d), new Vec3D(x+w,y,z+d), c, sh));
        triangles.add(new Triangle(new Vec3D(x+w,y,z+d), new Vec3D(x,y+h,z+d), new Vec3D(x+w,y+h,z+d), c, sh));

    }
}
