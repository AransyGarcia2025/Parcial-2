# Registro de Usuarios con Validaciones en Java

Este proyecto es una aplicación de consola desarrollada en Java que permite gestionar el registro y la validación de usuarios.  
El sistema valida correctamente los datos ingresados utilizando expresiones regulares y sigue principios de Programación Orientada a Objetos (POO).

## Características

- Registro de usuarios con validación de:
  - Nombre (solo letras y espacios).
  - Correo electrónico (formato estándar).
  - Contraseña segura:
    - Mínimo 8 caracteres.
    - Al menos 1 carácter especial.
    - Al menos 2 letras mayúsculas.
    - Al menos 3 letras minúsculas.
    - Al menos 1 número.
- Almacenamiento de usuarios en un archivo `usuarios.txt`.
- Validación de usuarios existentes con saludo personalizado si las credenciales son correctas.
- Menú interactivo en consola para facilitar la navegación.

## Estructura del Proyecto
📂 src ├── RegistroUsuariosApp.java 
          ├── User.java 
              └── Validador.java 
              📄 usuarios.txt 
              📄 README.md 
              📄 .gitignore

## Requisitos

- Java JDK 8 o superior.
- Editor o IDE de tu preferencia (IntelliJ IDEA, Eclipse, VSCode, etc.).

## Compilación y Ejecución

### Compilar:
bash javac RegistroUsuariosApp.java User.java Validador.java
