package Interfaz;

import Entidades.Pacientes;

public class App {
    public static void main(String[] args) {
        String rut, nombre, sexo;
        int pesoMensual[];
        int edad;
        int altura = 0;
//Rut, nombre, edad, sexo (F para femenino y M para masculino) y peso mensual (array con los pesos mensuales del año).
        Pacientes paciente = null;

        int opcion;
        do {
            System.out.println("---           Sanatorio Contigo Aprendo                          ---");
            System.out.println("---      1) Registrar paciente                                   ---");
            System.out.println("---      2) Mostrar todos los atributos del paciente             ---");
            System.out.println("---      3) Mostrar el mes con menor peso del paciente           ---");
            System.out.println("---      4) Ingrese un peso para comparar con el paciente        ---");
            System.out.println("---      5) Calcular el IMC de Noviembre con la altura ingresada ---");
            System.out.println("---      6) Salir                                                ---");
            System.out.println("--------------------------------------------------------------------");
            System.out.println(" Favor ingrese una opción para continuar (Ej: 1):      ");
            opcion = Leer.datoInt();

            switch (opcion) {
                case 1:
                    //opcion 1 (Ingreso)
                    // •	1) Crear un objeto de tipo Paciente. (estatura 1mt a 2,30mt)
                    System.out.println("Favor ingrese el Rut del paciente: ");
                    rut = Leer.dato();

                    System.out.println("Favor ingrese el nombre del paciente: ");
                    nombre = Leer.dato();

                    System.out.println("Favor ingrese el sexo del paciente ('M' o 'F'): ");
                    sexo = Leer.dato();

                    System.out.println("Favor ingrese la edad del paciente: ");
                    edad = Leer.datoInt();
// (23376467,"Pablo Brion",51,'M');
                    paciente = new Pacientes(rut, nombre, edad, sexo);
                    do {
                        System.out.println("Favor ingrese la altura en centímetros del paciente: ");
                        altura = Leer.datoInt();
                    } while (altura < 100 || altura > 230);
                    break;
                case 2:
                    if (paciente == null) {
                        System.out.println("Favor registre paciente");
                    } else {
                        // •	2) Mostrar todos los atributos del paciente registrado (objeto).
                        System.out.println("--------------- Ficha del paciente: ----------------------");
                        System.out.println("RUT del paciente: "+paciente.getDni());
                        System.out.println("Nombre del paciente: "+paciente.getNombre());
                        System.out.println("Sexo del paciente: "+paciente.getSexo());
                        System.out.println("Edad del paciente: "+paciente.getEdad());
                        //System.out.println("altura del paciente: "+altura);
                        for (int i = 0; i < paciente.getPesoMensual().length; i++) {
                            System.out.println("Mes "+ (i+1) + " peso del paciente: " + paciente.getPesoMensual()[i]);
                        }
                        System.out.println("----------------------------------------------------------");
                    }
                    break;
                case 3:
                    if (paciente == null) {
                        System.out.println("Favor registre paciente");
                    } else {
                        // •	3) Mostrar el mes con menor peso del paciente registrado (objeto).
                        System.out.println("Menor Peso en el mes: " + paciente.menorPesoMensual());
                    }
                    break;
                case 4:
                    if (paciente == null) {
                        System.out.println("Favor registre paciente");
                    } else {
                        //•	4) Solicitar el ingreso de un peso para comparar y si el metodo menosDeXKilos retorna valor distinto de null, mostrar array con los meses en que el paciente pesó menos kilos que los ingresados por el usuario, de lo contrario dar mensaje adecuado.
                        System.out.println("Favor Ingrese el peso para comparar con el paciente: ");
                        int pesoComparacion = Leer.datoInt();
                        int mesReal=0;
                        int[] pesoComparado = new int[0];
                        int[] mesComparado = new int[0];
                        for (int i = 0; i < 12; i++) {
                                mesReal= (i+1);
                            if (paciente.getPesoMensual()[i] < pesoComparacion) {
                                pesoComparado = paciente.agregarElemento(pesoComparado,paciente.getPesoMensual()[i]);
                                mesComparado =paciente.agregarElemento(mesComparado,mesReal);
                            }
                            }
                        System.out.println("Mes/meses en que el paciente pesó menos que el valor comparado " + pesoComparacion + ", son: ");
                        for (int i = 0; i < mesComparado.length; i++) {
                            System.out.println("Mes: " + mesComparado[i]);
                        }
                    }
                    break;
                case 5:
                    if (paciente == null) {
                        System.out.println("Favor registre paciente");
                    } else {
                        // •	5) Dada la estatura, mostrar la condición del paciente en el mes de noviembre (normal, sobrepeso u obeso).
                        System.out.println("Peso en el mes de noviembre: "+ paciente.pesoMesX(11,altura));
                    }
                    break;
            }

        } while (opcion != 6);
    }
}




