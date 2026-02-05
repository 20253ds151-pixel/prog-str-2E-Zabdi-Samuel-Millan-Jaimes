public class ShippingCalculator {
public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota) {
        double subtotal = (tipoServicio == 1) ? 50 : 90;
        subtotal += pesoKg * 12;

        if (distanciaKm <= 50) subtotal += 20;
        else if (distanciaKm <= 200) subtotal += 60;
        else subtotal += 120;

        if (zonaRemota) subtotal *= 1.10;
        return subtotal;
    }

    public double calcularIVA(double subtotal) {
        return subtotal * 0.16;
    }

    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
}