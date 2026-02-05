public class App {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        InputValidator validator = new InputValidator();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int cantidad = validator.optenerNumeroEntero("Ingrese la cantidad de boletos: ", scanner);
        ticket.calcularSubtotal(cantidad);
        ticket.calculaDescuento(ticket.subtotal);
        ticket.calcularTotal(ticket.subtotal);
        ticket.mostrarTotal(cantidad);
        scanner.close();
    }
}