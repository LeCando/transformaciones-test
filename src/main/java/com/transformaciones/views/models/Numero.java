package com.transformaciones.views.models;

import java.util.Scanner;

public class Numero {


    public int numero;
    public int binario;
    public String hexadecimal;


    public Numero(int numero, int binario, String hexadecimal) {
        this.numero = numero;
        this.binario = binario;
        this.hexadecimal = hexadecimal;
    }

    public Numero() {
    }
    public void ingresarNumeros(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero que desea transformar:");
        this.numero = Integer.parseInt(scanner.nextLine());
    }

    public void imprimirClientes(){
        System.out.println("Numero Binario: "+this.binario);
        System.out.println("Numero Hexadecimal: "+this.hexadecimal);
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getBinario() {
        return binario;
    }

    public void setBinario(int binario) {
        this.binario = binario;
    }

    public String getHexadecimal() {
        return hexadecimal;
    }

    public void setHexadecimal(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }
}
