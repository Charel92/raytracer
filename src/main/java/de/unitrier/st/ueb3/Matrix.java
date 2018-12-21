package main.java.de.unitrier.st.ueb3;

import java.util.List;

public class Matrix {
    float val [][] = new float[4][4];

    Matrix() { }
    Matrix(float [][] vs) { val=vs; }

    void print()
    { for(int i=0;i<4;i++)
    { for(int j=0;j<4;j++)
    { System.out.print(" "+(val[i][j]+"       ").substring(0,8)); }
        System.out.println();
    }
    }


    Matrix mult(Matrix m)
    { Matrix r=new Matrix();
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
            { float sum=0f;
                for(int k=0;k<4;k++) sum=sum+val[i][k]*m.val[k][j];
                r.val[i][j]=sum;
            }
        return r;
    }

    Vec3D mult(Vec3D v)
    { Vec3D temp = new Vec3D( val[0][0]*v.x+val[0][1]*v.y+val[0][2]*v.z+val[0][3]*v.w,
            val[1][0]*v.x+val[1][1]*v.y+val[1][2]*v.z+val[1][3]*v.w,
            val[2][0]*v.x+val[2][1]*v.y+val[2][2]*v.z+val[2][3]*v.w,
            val[3][0]*v.x+val[3][1]*v.y+val[3][2]*v.z+val[3][3]*v.w );
        //return new Vec3D(temp.x/temp.w,temp.y/temp.w,temp.z/temp.w,1);
        temp.x=temp.x/temp.w; temp.y=temp.y/temp.w; temp.z=temp.z/temp.w; temp.w=1;
        return temp;
    }

    static Matrix createId()
    { return new Matrix(new float[][]{
            { 1, 0, 0, 0},
            { 0, 1, 0, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 0, 1 } });
    }

    static Matrix createXRotation(float angle)
    { return new Matrix(new float[][]{
            { 1, 0, 0 , 0},
            { 0, (float)Math.cos(angle), (float)-Math.sin(angle), 0 },
            { 0, (float)Math.sin(angle), (float)Math.cos(angle),0 },
            { 0 , 0, 0, 1 } });
    }

    static Matrix createYRotation(float angle)
    { return new Matrix(new float[][]{
            { (float)Math.cos(angle), 0, (float)Math.sin(angle), 0 },
            { 0, 1, 0, 0 },
            { (float)-Math.sin(angle), 0, (float)Math.cos(angle), 0 },
            { 0, 0, 0, 1 } });
    }

    static Matrix createZRotation(float angle)
    { return new Matrix(new float[][]{
            { (float)Math.cos(angle), (float)-Math.sin(angle), 0, 0 },
            { (float)Math.sin(angle), (float)Math.cos(angle), 0, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 0, 1 }  });
    }

    static Matrix createTranslation(float dx, float dy, float dz)
    { return new Matrix(new float[][]{
            { 1, 0, 0, dx },
            { 0, 1, 0, dy },
            { 0, 0, 1, dz },
            { 0, 0, 0, 1  } });
    }

    void apply(List<Triangle> ts)
    { for(Triangle t: ts)
    { t.p1=this.mult(t.p1);
        t.p2=this.mult(t.p2);
        t.p3=this.mult(t.p3);
        Vec3D e1=t.p2.minus(t.p1),
                e2=t.p3.minus(t.p1);
        t.normal=e1.cross(e2);
        t.normal.normalize();
    }
    }
}