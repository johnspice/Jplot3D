package com.juangabrellopezh.jplo3drenderer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.juangabrellopezh.jplot3d.ViewEngine3D;
import com.juangabrellopezh.jplot3d.matrix.Vector3;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {

    LinearLayout screenPaint;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screenPaint = findViewById(R.id.ly_draw);
        context=this;

        /*
        in xml screenPaint width>height   --> width greater than height
        android:layout_width="601"
        android:layout_height="600"
        */

        paintPLY("fig3d");
    }

    public void drawMonkey(View view){
        paintPLY("monkey");
        //paintPLY("fig3d");
    }

    public void paintPLY(String fileply){
        InputStream in =getResources().openRawResource(getResources().getIdentifier(fileply, "raw", getPackageName()));
        try {
            screenPaint.removeAllViews();
            ViewEngine3D  viewEngine3D = new ViewEngine3D(context,in );
            //viewEngine3D.ColorMesh = Color.GRAY;
            //viewEngine3D.showAxis=false;
            //viewEngine3D.onTouch=false;
            viewEngine3D.setThemeDark();
            screenPaint.addView(viewEngine3D);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void paintCurve(View view){
        screenPaint.removeAllViews();//clear view
        ViewEngine3D viewEngine3D=new ViewEngine3D(context,heliceConico());
        screenPaint.addView(viewEngine3D);

    }

    public void paintMultipleCurve(View view){
        Vector3[] v=new Vector3[8];
        v[0]=new Vector3(1,1,1);
        v[1]=new Vector3(-1,1,1);
        v[2]=new Vector3(-1,-1,1);
        v[3]=new Vector3(1,-1,1);
        v[4]=new Vector3(1,-1,-1);
        v[5]=new Vector3(-1,-1,-1);
        v[6]=new Vector3(-1,1,-1);
        v[7]=new Vector3(1,1,-1);
        Vector3[] v2=new Vector3[8];
        v2[0]=new Vector3(1-5,1,1);
        v2[1]=new Vector3(-1-5,1,1);
        v2[2]=new Vector3(-1-5,-1,1);
        v2[3]=new Vector3(1-5,-1,1);
        v2[4]=new Vector3(1-5,-1,-1);
        v2[5]=new Vector3(-1-5,-1,-1);
        v2[6]=new Vector3(-1-5,1,-1);
        v2[7]=new Vector3(1-5,1,-1);
        Vector3[] v3=new Vector3[8];
        v3[0]=new Vector3(1-5,1,1+5);
        v3[1]=new Vector3(-1-5,1,1+5);
        v3[2]=new Vector3(-1-5,-1,1+5);
        v3[3]=new Vector3(1-5,-1,1+5);
        v3[4]=new Vector3(1-5,-1,-1+5);
        v3[5]=new Vector3(-1-5,-1,-1+5);
        v3[6]=new Vector3(-1-5,1,-1+5);
        v3[7]=new Vector3(1-5,1,-1+5);
        screenPaint.removeAllViews();
        ViewEngine3D viewEngine3D=new ViewEngine3D(context,v,v2,v3);//max. 3
        //viewEngine3D.ColorMesh = Color.GRAY;
        //viewEngine3D.axis=false;
        //viewEngine3D.onTouch=false;
        //viewEngine3D.setThemeDark();
        viewEngine3D.setStrokeWidthLine(19);
        screenPaint.addView(viewEngine3D);

    }


    private Vector3[] heliceConico(){
        float h=10,r=5,a=6; //h=altura cono , r=radio del cono, a=numero de espiras
        Vector3[] vector3=new Vector3[400];
        for(int z=0;z<400;z++){
            double x,y;
            x=((h-z)/h)*r*Math.cos(a*z);
            y=((h-z)/h)*r*Math.sin(a*z);
            vector3[z]=new Vector3((float) x,(float) y,(float) z);
        }
        return vector3;
    }



}