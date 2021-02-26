# Jplot3D
## Pequeño Motor De Renderizado 3D para Android

![GitHub Logo](/image/monogif.gif)![GitHub Logo](/image/cubogif.gif)
![GitHub Logo](/image/curvas.png)


El motor usa la clase View que permite dibujar puntos, lineas, texto etc. usando un canvas en 2D,
se utilizan transformaciones lineales para proyectar puntos 3D a un espacio 2D mediante operaciones
matriciales usando las matrices de projeccion, de mundo y de transformacion. Todos los puntos
son renderizados en tiempo real. Por lo que podria no ser muy eficiente, para mayor eficiencia usar openGL.

En la imagen se observa monkey el modelo 3d de blender exportado en .ply  con 507 vertices o figuras3d (esfera, cilindro, cono y toro) con 1155 vertices.




Pudes usarla para:
- Renderizar un objeto3D exportado desde Blender o cualquier otro soft3D. El modelo3D debe ser exportdao en formato .ply (Polygon File Format)
- Renderizar una conjunto de puntos (x,y,z) 
- curvas

## Agregar a Android studio usando Gradle
en el archivo build.gradle(:app) agrega lo siguiente;

    repositories {
      maven {
        url 'https://dl.bintray.com/juangabriel/jplot'
      }
    }


    dependencies {
      implementation 'com.gabrielopez.plot:jplot3D:1.0.1'
    }
    
## Como usar
Revisar Codigo ejemplo en este repo.
dentro del .xml agregar;

     <LinearLayout
       android:id="@+id/ly_mycanvas"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:orientation="horizontal">
     </LinearLayout>

debe cumplir que width > height. en el activity agregar;
   
    public class MainActivity extends AppCompatActivity {
        private LinearLayout lyCanvas;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            lyCanvas= findViewById(R.id.ly_mycanvas);
           
            Vector3[] v=new Vector3[4];
            v[0]=new Vector3(1,1,1);
            v[1]=new Vector3(-1,1,1);
            v[2]=new Vector3(-1,-1,1);
            v[3]=new Vector3(1,-1,1);
            ViewEngine3D viewEngine3D=new ViewEngine3D(this,v);
            lyCanvas.addView(viewEngine3D);

          }
      }    



## Exportar objeto .ply de Blender
Desde blender selecciona uno o varios objetos a exportar. Jplot3D trabaja bien con hasta unos 1500 vertices en un smartphone de 4gb ram
para mas vertices podria no ser muy eficiente, quisa deba usar openGL.  
![GitHub Logo](/image/export.png)

agregar raw folder dentro de res. monkey.ply  debe estar dentro de raw
como se observa en la siguiente imagen.

![GitHub Logo](/image/addply.png)

dentro del activity; 

        //cargar el arcchivo .ply exportado desde blender 
        InputStream in =getResources().openRawResource(getResources().getIdentifier("monkey", "raw", getPackageName()));
        lyCanvas.removeAllViews();//limpiar LinearLayout
        ViewEngine3D viewEngine3D= null;
        try {
            viewEngine3D = new ViewEngine3D(this,in );
            lyCanvas.addView(viewEngine3D);
        } catch (IOException e) { e.printStackTrace();}
        
 ## customs ViewEngine3D
 - Color del objeto: set color Vector1,Vector2,Vector3;
  
   - viewEngine3D.ColorMesh=Color.RED;
   - viewEngine3D.ColorMesh2=Color.BLUE;
   - viewEngine3D.ColorMesh=3Color.RED;
 - Hide Axis;
 
   viewEngine3D.axis=false;
 - Theme Dark

    viewEngine3D.setThemeDark(); 
    
 - setStrokeWidth: set Width line pixels.
 
    viewEngine3D.setStrokeWidthLine(12);  
 
 - set position target and camera. 
   - viewEngine3D.setPositionCamera(new Vector3(5,5,5));
   - viewEngine3D.setTarget(new Vector3(1,0,1));
   
   ![GitHub Logo](/image/camera.png)  
