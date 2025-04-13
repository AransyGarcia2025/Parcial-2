import java.util.regex.Pattern;

public class Validador {
    private static final Pattern PATRON_NOMBRE = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$");
    private static final Pattern PATRON_CORREO = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PATRON_CONTRASEÑA = Pattern.compile("^(?=(?:.*[A-Z]){2,})(?=(?:.*[a-z]){3,})(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$");

    public static boolean validarNombre(String nombre) {
        return PATRON_NOMBRE.matcher(nombre).matches();
    }

    public static boolean validarCorreo(String correo) {
        return PATRON_CORREO.matcher(correo).matches();
    }

    public static boolean validarContraseña(String contraseña) {
        return PATRON_CONTRASEÑA.matcher(contraseña).matches();
    }
}
