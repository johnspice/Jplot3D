# Jplot3D
## Pequeño Motor De Renderizado 3D para Android

![GitHub Logo](/image/monogif.gif)![GitHub Logo](/image/cubogif.gif)
![GitHub Logo](/image/figuras.png)


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
--- En Construccion
## Como usar

 
