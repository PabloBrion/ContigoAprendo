package Interfaz;

import Entidades.Pacientes;

public class App_prueba {

    public static void main(String[] args) {
        Entidades.Pacientes pacientes;
        pacientes= new Pacientes("23376467","Pablo Brion",51, "M");

        System.out.println("Dni del paciente: " + pacientes.getDni());
        System.out.println("Nombre del paciente: " + pacientes.getNombre());
        System.out.println("Edad del paciente: " + pacientes.getEdad());
        System.out.println("Sexo del paciente: " + pacientes.getSexo());

        for (int i = 0; i < pacientes.getPesoMensual().length; i++) {
            System.out.println("Mes "+ (i+1) + " peso del paciente: " + pacientes.getPesoMensual()[i]);
        }

        System.out.println("Ingrese la altura del paciente, en centímetros: ");
        int altura= Interfaz.Leer.datoInt();

        System.out.println("Menor Peso en el mes: " + pacientes.menorPesoMensual());

        System.out.println("IMC de junio: " + pacientes.indiceMasaCorporal(6,altura));

        System.out.println("Ingrese la altura del paciente, en centímetros: ");
        int xaltura= Interfaz.Leer.datoInt();
        System.out.println("Peso en el mes de noviembre: "+ pacientes.pesoMesX(11,xaltura));


    }

}
