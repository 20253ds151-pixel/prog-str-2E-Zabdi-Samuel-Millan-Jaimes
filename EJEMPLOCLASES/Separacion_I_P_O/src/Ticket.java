public class Ticket {
    public void imprimirTicket(int serv, double p, int d, boolean zonare, double subtot, double iva, double tot) {
        System.out.println("\n=======================================");
        System.out.println("           TICKET DE ENVÍO             ");
        System.out.println("=======================================");
        System.out.printf(" Servicio:      %s\n", (serv == 1 ? "Estándar" : "Express"));
        System.out.printf(" Peso:          %.2f kg\n", p);
        System.out.printf(" Distancia:     %d km\n", d);
        System.out.printf(" Zona Remota:   %s\n", (zonare ? "Sí" : "No"));
        System.out.println("---------------------------------------");
        System.out.printf(" Subtotal:      $%10.2f\n", subtot);
        System.out.printf(" IVA (16%%):     $%10.2f\n", iva);
        System.out.println("---------------------------------------");
        System.out.printf(" TOTAL FINAL:   $%10.2f\n", tot);
        System.out.println("=======================================\n");
    }
}
  
