import java.io.*;
import java.util.Scanner;

public class RegistroUsuariosApp {
    private static final String ARCHIVO_USUARIOS = "usuarios.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("=== Menú de Opciones ===");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Validar usuario");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    validarUsuario();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 3);
    }

    private static void registrarUsuario() {
        System.out.println("=== Registro de Usuarios ===");

        System.out.print("Ingrese su nombre completo: ");
        String nombre = scanner.nextLine();
        while (!Validador.validarNombre(nombre)) {
            System.out.print("❌ Nombre inválido. Solo letras y espacios. Intente de nuevo: ");
            nombre = scanner.nextLine();
        }

        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        while (!Validador.validarCorreo(correo)) {
            System.out.print("❌ Correo inválido. Intente de nuevo: ");
            correo = scanner.nextLine();
        }

        System.out.println("La contraseña debe tener al menos 8 caracteres, incluir al menos un carácter especial, dos mayúsculas, tres minúsculas y un número.");
        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();
        while (!Validador.validarContraseña(contraseña)) {
            System.out.println("❌ Contraseña inválida. Debe tener al menos 8 caracteres, incluir al menos un carácter especial, dos mayúsculas, tres minúsculas y un número.");
            System.out.print("Intente de nuevo: ");
            contraseña = scanner.nextLine();
        }

        User nuevoUsuario = new User(nombre, correo, contraseña);
        guardarUsuario(nuevoUsuario);
        System.out.println("✅ Usuario registrado exitosamente.\n");
    }

    private static void validarUsuario() {
        System.out.println("=== Validar Usuario ===");

        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_USUARIOS))) {
            String linea;
            boolean encontrado = false;

            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    String nombreArchivo = datos[0];
                    String correoArchivo = datos[1];
                    String contraseñaArchivo = datos[2];

                    if (correoArchivo.equals(correo) && contraseñaArchivo.equals(contraseña)) {
                        System.out.println("✅ Bienvenido, " + nombreArchivo + "!\n");
                        encontrado = true;
                        break;
                    }
                }
            }

            if (!encontrado) {
                System.out.println("❌ Usuario no encontrado o credenciales incorrectas.\n");
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios: " + e.getMessage());
        }
    }

    private static void guardarUsuario(User usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_USUARIOS, true))) {
            writer.write(usuario.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el usuario: " + e.getMessage());
        }
    }
}
