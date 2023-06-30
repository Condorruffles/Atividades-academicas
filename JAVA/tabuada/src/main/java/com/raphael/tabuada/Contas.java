/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raphael.tabuada;

import java.util.Scanner;
/**
 *
 * @author Condoriano
 */
public class Contas {
     double resultado;
    
    Scanner leia = new Scanner(System.in);
    public void menu()
    {
        System.out.println("Qual operacao deseja realizar? Digite o numero:\n"
                + "1 Soma\n"
                + "2 Subtracao\n"
                + "3 Divisao\n"
                + "4 Multiplicacao\n"
                + "0 Encerrar o programa\n");
        
        int opcaoSelecionada = leia.nextInt();
        if (opcaoSelecionada == 0) System.exit(0);  // encerra a aplicação
        
        System.out.println("Digite o 1 numero: ");
        double n1 = leia.nextDouble();        
        
        System.out.println("Digite o 2 numero: ");
        double n2 = leia.nextDouble();
        
        System.out.println(opcaoSelecionada);
        
        
        if (opcaoSelecionada == 1) soma(n1, n2);
        if (opcaoSelecionada == 2) subtracao(n1, n2);
        if (opcaoSelecionada == 3) divisao(n1, n2);
        if (opcaoSelecionada == 4) multiplicacao(n1, n2);
        
        
       System.out.println("Quer fazer outra conta? [S/N]:");
       String decisao = leia.next().toUpperCase();               
       if ("S".equals(decisao)) menu();
       if (!"S".equals(decisao)||!"s".equals(decisao)) System.out.println("Fechando o programa");
       
    }
    
    public void soma(double n1, double n2)
    {        
        resultado = n1 + n2;
        System.out.println(n1 + " + " + n2 + " = " + resultado);
        
    }
    
    public void subtracao(double n1, double n2)
    {
        resultado = n1 - n2;
        System.out.println(n1 + " - " + n2 + " = " + resultado);
    }
        
    public void divisao(double n1, double n2)
    {
        if (n2 == 0) 
        {
            System.out.println("Não é possível dividir por 0");
        } else
        {
            resultado = n1 / n2;
            System.out.println(n1 + " / " + n2 + " = " + resultado);
        }
    }
    
    public void multiplicacao(double n1, double n2)
    {
        resultado = n1* n2;
        System.out.println(n1 + " x " + n2 + " = " + resultado);
}
}
