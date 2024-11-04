package Entidades;

import java.util.Arrays;

public class Pacientes {
    private String dni;
    private String nombre;
    private int edad;
    private String sexo;
    private int[] pesoMensual;


    public Pacientes(String dni, String nombre, int edad, String sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.pesoMensual = new int[12];

        for (int i = 0; i < 12; i++) {
            pesoMensual[i]= (int) ((Math.random()*(180))+70 );

        }
    }

    //vacio
    public Pacientes() {
    }



    public int[] getPesoMensual() {
        return pesoMensual;
    }

    public void setPesoMensual(int[] pesoMensual) {
        this.pesoMensual = pesoMensual;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    //  ---   Métodos   ---

    //menorPesoMensual	Int
    // •	menorPesoMensual: retorna el mes en que el paciente peso menos kilos.
    public int menorPesoMensual(){
        int menorPeso=251;
        int mesMenor=0;

        for (int i = 0; i < 12; i++) {
            if (menorPeso > pesoMensual[i]) {
                mesMenor= (i+1);
                menorPeso= pesoMensual[i];
                // System.out.println("Mes:  " + mesMenor + " peso: " + menorPeso);
            }
        }
        // Me gustaría llevar los dos argumentos, averiguar como se hace.
        return mesMenor;
    }

    //indiceMasaCorporal	Int
    // •	indiceMasaCorporal: retorna el índice de masa corporal del paciente, para un mes x.
    // índice de masa corporal = peso/estatura2
    public double indiceMasaCorporal(int mes, int altura) {
        double imc = 0;
        System.out.println("xx altura (cm): " + altura);

        // Convertir altura de centímetros a metros
        double alturaEnMetros = altura / 100.0;

        int peso = pesoMensual[mes - 1]; // Uso el mes para cargar el peso usando pesoMensual
        System.out.println("xx peso mes " + mes + ": " + peso);

        if (alturaEnMetros <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor que cero.");
        }

        // Calcular el IMC usando la altura en metros
        imc = peso / (alturaEnMetros * alturaEnMetros);
        System.out.println("xx imc: " + imc);
        return imc;
    }


    //menosDeXKilos	Int[]
    // •	menosDeXKilos: retorna un nuevo array en el que se almacenan los meses en que el paciente pesó menos de X kilos. Si nunca lo hizo, retorna null.
    public int[] menosDeXKilos(int xkilos) {
        int[] menosKilos = new int[0];  // Arreglo inicial vacío
        for (int i = 0; i < pesoMensual.length; i++) {
            if (xkilos > pesoMensual[i]) {
                menosKilos = Arrays.copyOf(menosKilos, menosKilos.length + 1);  // Aumentar tamaño del arreglo
                menosKilos[menosKilos.length - 1] = pesoMensual[i];
            }
        }
        return menosKilos;
    }


    //pesoMesX	String
    // •	pesoMesX: retorna la palabra normal, sobrepeso u obeso de acuerdo con el índice de masa corporal (IMC) obtenido en el mes del año se indique. (Debe usar metodo indiceMasaCorporal)
    // 15 <= IMC < 20     Normal
    //    20 <= IMC < 28     Sobrepeso
    //             IMC >= 28     Obeso
    public String pesoMesX(int mes, int altura) {
        String pesoMes = "Normal";  // Arranca en Normal
        double nroIMC= indiceMasaCorporal(mes, altura);
        if (nroIMC >= 20 && nroIMC < 28) {
            pesoMes = "Sobrepeso";
        } else if (nroIMC >= 28) {
            pesoMes = "Obeso";
        }
        if (nroIMC < 15) {
            pesoMes = "Fuera de parámetros";
        }
        return pesoMes;
    }

    // Método para agregar un elemento al array
    public int[] agregarElemento(int[] array, int elemento) {
        int[] nuevoArray = new int[array.length + 1]; // Nuevo array con espacio adicional
        System.arraycopy(array, 0, nuevoArray, 0, array.length); // Copiar elementos del array original
        nuevoArray[nuevoArray.length - 1] = elemento; // Agregar el nuevo elemento al final
        return nuevoArray;
    }

    //estatura	Double
    // Rnd entre 1 mt y 2,30 mts
    //    ****       NO SE PUEDE HACER DE ESTA FORMA PORQUE SINO MUESTRA UNA ALTURA DIFERENTE CADA VEZ QUE SE LLAMA     ****
    /*
    public double estatura(){
        double altura=0;
        altura= (Math.random()*(100))+130 ;    //obtengo la altura en cm
        altura= altura /100;     // la convierto en metros
        altura= Math.round(altura * 100.0) / 100.0;    //redondéo dos decimales
        return altura;
    }

*/
}
