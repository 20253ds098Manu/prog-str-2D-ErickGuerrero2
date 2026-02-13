public class ValidarValor {

    public boolean validarRango(int valor) {
        if (valor >= 0) {
            if (valor <= 20) {
                return true;
            }
        }
        return false;
    }

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
}