public class ValidarValor {

    public boolean validarIdPositivo(int id) {
        if (id > 0) {
            return true;
        }
        return false;
    }

    public boolean validarTexto(String texto) {
        if (texto.equals("")) {
            return false;
        }
        return true;
    }

    public boolean validarPromedio(double promedio) {
        if (promedio >= 0) {
            if (promedio <= 10) {
                return true;
            }
        }
        return false;
    }
}