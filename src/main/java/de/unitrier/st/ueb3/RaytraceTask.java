package main.java.de.unitrier.st.ueb3;

import java.util.concurrent.Callable;

public class RaytraceTask implements Callable {
    SDRaytracer tracer;
    int i;
    RaytraceTask(SDRaytracer t, int ii) { tracer=t; i=ii; }

    public RGB[] call()
    { RGB[] col=new RGB[tracer.height];
        for (int j=0;j<tracer.height;j++)
        {  tracer.image[i][j]=new RGB(0,0,0);
            for(int k=0;k<tracer.rayPerPixel;k++)
            { double di=i+(Math.random()/2-0.25);
                double dj=j+(Math.random()/2-0.25);
                if (tracer.rayPerPixel==1) { di=i; dj=j; }
                Ray eye_ray=new Ray();
                eye_ray.setStart(tracer.startX, tracer.startY, tracer.startZ);   // ro
                eye_ray.setDir  ((float) (((0.5 + di) * tracer.tan_fovx * 2.0) / tracer.width - tracer.tan_fovx),
                        (float) (((0.5 + dj) * tracer.tan_fovy * 2.0) / tracer.height - tracer.tan_fovy),
                        (float) 1f);    // rd
                eye_ray.normalize();
                col[j]= tracer.addColors(tracer.image[i][j],tracer.rayTrace(eye_ray,0),1.0f/tracer.rayPerPixel);
            }
        }
        return col;
    }
}
