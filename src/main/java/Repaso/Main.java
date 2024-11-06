package Repaso;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double maxHeight = 0, minHeigth = Double.MAX_VALUE, promHeight, maxWeight = 0, minWeight=Double.MAX_VALUE, promWeight, maxImc = 0, minImc = 0,
                promImc, sumAltura = 0, sumPeso = 0, sumImc = 0;
        int cantidad;
        String nameStudent;
        Scanner sc = new Scanner(System.in);

        System.out.println("Señor usuario, por favor, ingresar la cantidad de estudiantes a ingresar en el sistema");
        cantidad = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer
        double[] estaturaEstudiantes = new double[cantidad];
        double[] pesoEstudiantes = new double[cantidad];
        String[] nombreEstudiantes = new String[cantidad];
        double[] imc = new double[cantidad];

        // Nombres de los estudiantes
        for (int n = 0; n < nombreEstudiantes.length; n++) {
            System.out.println("Señor usuario, por favor, ingresar el nombre del estudiante " + (n + 1));
            nombreEstudiantes[n] = sc.nextLine();
        }

        // Estaturas
        for (int i = 0; i < estaturaEstudiantes.length; i++) {
            System.out.println("Señor usuario, por favor, ingresar la estatura del estudiante " + nombreEstudiantes[i]);
            estaturaEstudiantes[i] = sc.nextDouble();
            sumAltura += estaturaEstudiantes[i];
        }

        // Pesos
        for (int p = 0; p < pesoEstudiantes.length; p++) {
            System.out.println("Señor usuario, por favor, ingresar el peso del estudiante " + nombreEstudiantes[p]);
            pesoEstudiantes[p] = sc.nextDouble();
            sumPeso += pesoEstudiantes[p];
        }

        // Calcular IMC
        for (int o = 0; o < imc.length; o++) {
            imc[o] = pesoEstudiantes[o] / Math.pow(estaturaEstudiantes[o], 2);
            sumImc += imc[o];
        }

        // Variables para almacenar los nombres de los estudiantes con max/min altura
        String maxHeightName = "", minHeightName = "";
        // Obtener altura máxima y mínima
        for (int l = 0; l < estaturaEstudiantes.length; l++) {
            if (estaturaEstudiantes[l] > maxHeight) {
                maxHeight = estaturaEstudiantes[l];
                maxHeightName = nombreEstudiantes[l]; // Guarda el nombre del estudiante con la altura máxima
            }
            if (estaturaEstudiantes[l] < minHeigth) {
                minHeigth = estaturaEstudiantes[l];
                minHeightName = nombreEstudiantes[l]; // Guarda el nombre del estudiante con la altura mínima
            }
        }

        // Variables para almacenar los valores máximos y mínimos de peso e IMC
        String maxWeightName = "", minWeightName = "", maxImcName = "", minImcName = "";

        // Obtener máximos y mínimos de peso
        for (int w = 0; w < pesoEstudiantes.length; w++) {
            if (pesoEstudiantes[w] > maxWeight) {
                maxWeight = pesoEstudiantes[w];
                maxWeightName = nombreEstudiantes[w]; // Nombre del estudiante con el peso máximo
            }
            if (pesoEstudiantes[w] < minWeight) {
                minWeight = pesoEstudiantes[w];
                minWeightName = nombreEstudiantes[w]; // Nombre del estudiante con el peso mínimo
            }
        }

        // Obtener máximos y mínimos de IMC
        for (int w = 0; w < imc.length; w++) {
            if (imc[w] > maxImc) {
                maxImc = imc[w];
                maxImcName = nombreEstudiantes[w]; // Nombre del estudiante con el IMC máximo
            }
            if (imc[w] < minImc) {
                minImc = imc[w];
                minImcName = nombreEstudiantes[w]; // Nombre del estudiante con el IMC mínimo
            }
        }

        // Promedios
        promHeight = sumAltura / cantidad;
        promWeight = sumPeso / cantidad;
        promImc = sumImc / cantidad;


        System.out.println("""
                Señor usuario, por favor, ingresar una opcion:
                 1) Estadística de Altura.
                 2) Estadística de Peso.
                 3) Estadística de IMC.
                 4) Salir""");

        boolean salir = true;

        // Bucle para mostrar las opciones
        do {
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("La altura máxima es: " + maxHeight + " y pertenece al estudiante: " + maxHeightName);
                    System.out.println("La altura mínima es: " + minHeigth + " y pertenece al estudiante: " + minHeightName);
                    System.out.println("El promedio de las alturas es: " + promHeight);
                    break;
                case 2:
                    System.out.println("El peso máximo es: " + maxWeight + " y pertenece al estudiante: " + maxWeightName);
                    System.out.println("El peso mínimo es: " + minWeight + " y pertenece al estudiante: " + minWeightName);
                    System.out.println("El promedio de los pesos es: " + promWeight);
                    break;
                case 3:
                    System.out.println("El IMC máximo es: " + maxImc + " y pertenece al estudiante: " + maxImcName);
                    System.out.println("El IMC mínimo es: " + minImc + " y pertenece al estudiante: " + minImcName);
                    System.out.println("El promedio de los IMC es: " + promImc);
                    break;
                case 4:
                    System.out.println("Gracias por usar nuestro sistema, vuelve pronto.");
                    salir = false;
                    break;
                default:
                    System.out.println("Seleccione la opción correcta");
                    break;
            }
        } while (salir);
    }
}
