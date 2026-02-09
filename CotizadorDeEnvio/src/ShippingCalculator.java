public class ShippingCalculator {

    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota) {
        double base;
        if (tipoServicio == 1) {
            base = 50;
        } else {
            base = 90;
        }

        double costoPeso = pesoKg * 12;

        double costoDistancia;
        if (distanciaKm <= 50) {
            costoDistancia = 20;
        } else if (distanciaKm <= 200) {
            costoDistancia = 60;
        } else {
            costoDistancia = 120;
        }

        double subtotal = base + costoPeso + costoDistancia;

        if (zonaRemota) {
            subtotal = subtotal * 1.10;
        }

        return subtotal;
    }

    public double calcularIVA(double subtotal) {
        return subtotal * 0.16;
    }

    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
}