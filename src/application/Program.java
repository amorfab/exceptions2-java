package application;

import model.entities.Conta;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Entre com os dados da conta");
            System.out.print("Numero: ");
            Integer numero = sc.nextInt();
            sc.nextLine();
            System.out.print("Titular: ");
            String titular = sc.nextLine();
            System.out.print("Saldo Inicial: ");
            Double saldo = sc.nextDouble();
            System.out.print("Limite de Saque: ");
            Double limiteSaque = sc.nextDouble();

            Conta conta = new Conta(numero, titular, saldo, limiteSaque);

            System.out.println();
            System.out.print("Entre com o valor para saque: ");
            Double valor = sc.nextDouble();
            conta.sacar(valor);
            System.out.println(conta);
        }
        catch (DomainException e){
            System.out.println("Erro no saque: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Erro inexperado");
        }
        sc.close();
    }
}
