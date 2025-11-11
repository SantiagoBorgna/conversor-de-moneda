import com.conversor.api.ApiClient;
import com.conversor.api.ApiResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiClient apiClient = new ApiClient();

        while (true) {
            mostrarMenu();
            int opcion = leerOpcion(scanner);

            if (opcion == 7) {
                System.out.println("¡Gracias por usar el conversor!");
                break;
            }

            if (opcion < 1 || opcion > 6) {
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
                continue;
            }

            double cantidad = leerCantidad(scanner);

            String base = "";
            String nueva = "";

            switch (opcion) {
                case 1:
                    base = "USD";
                    nueva = "ARS";
                    break;
                case 2:
                    base = "ARS";
                    nueva = "USD";
                    break;
                case 3:
                    base = "USD";
                    nueva = "BRL";
                    break;
                case 4:
                    base = "BRL";
                    nueva = "USD";
                    break;
                case 5:
                    base = "USD";
                    nueva = "COP";
                    break;
                case 6:
                    base = "COP";
                    nueva = "USD";
                    break;
            }

            // Llamada a la API
            System.out.println("\nProcesando conversión, por favor espere...");
            ApiResponse respuesta = apiClient.getPairConversion(base, nueva, cantidad);

            if (respuesta != null) {
                System.out.println("Resultado de la Conversión:");
                System.out.printf("  %.2f %s equivalen a %.2f %s%n",
                        cantidad,
                        respuesta.getBaseCode(),
                        respuesta.getConversionResult(),
                        respuesta.getTargetCode());
                System.out.printf("  (Tasa de cambio: 1 %s = %.4f %s)%n",
                        respuesta.getBaseCode(),
                        respuesta.getConversionRate(),
                        respuesta.getTargetCode());
            } else {
                System.out.println("\n--- Error ---");
                System.out.println("No se pudo completar la conversión.");
                System.out.println("-------------");
            }

            System.out.println("Presione Enter para continuar...");
            scanner.nextLine();
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n*** Bienvenido al conversor de Moneda ***");
        System.out.println("***************************************************");
        System.out.println("Elija la conversión que desea realizar:");
        System.out.println("1) Dólar (USD)           =>> Peso Argentino (ARS)");
        System.out.println("2) Peso Argentino (ARS)  =>> Dólar (USD)");
        System.out.println("3) Dólar (USD)           =>> Real Brasileño (BRL)");
        System.out.println("4) Real Brasileño (BRL)  =>> Dólar (USD)");
        System.out.println("5) Dólar (USD)           =>> Peso Colombiano (COP)");
        System.out.println("6) Peso Colombiano (COP) =>> Dólar (USD)");
        System.out.println("\n7) Salir");
        System.out.println("***************************************************");
        System.out.print("Ingrese una opción: ");
    }

    private static int leerOpcion(Scanner scanner) {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    private static double leerCantidad(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese la cantidad que desea convertir: ");
            try {
                double cantidad = scanner.nextDouble();
                scanner.nextLine();
                if (cantidad > 0) {
                    return cantidad;
                } else {
                    System.out.println("Error: La cantidad debe ser un número positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido (ej. 150.50).");
                scanner.nextLine();
            }
        }
    }
}