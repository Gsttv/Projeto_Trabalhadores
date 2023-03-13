package App;

import Entites.ContratoPorHora;
import Entites.Departamento;
import Entites.Trabalhador;
import EntitesEnum.Level;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Digite o nome do departamento: ");
        String departamento = sc.nextLine();
        System.out.println("Digite os dados do trabalhador: ");
        System.out.println("NOME: ");
        String nomeTrab = sc.nextLine();
        System.out.println("LEVEL: ");
        String level = sc.nextLine();
        System.out.println("SALARIO: ");
        double salario = sc.nextDouble();

        Trabalhador trabalhador = new Trabalhador(nomeTrab, Level.valueOf(level), salario, new Departamento(departamento));

        System.out.println("Quanto contratos o trabalhador possui?: ");
        int qntContratos = sc.nextInt();

        for (int i =1; i<=qntContratos;i++){
            System.out.println("Informe os dados do contrato "+i);
            System.out.print("Data (dd/MM/yyyy): ");
            Date dataContrato = sdf.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valorHora = sc.nextDouble();
            System.out.print("Duração(horas): ");
            int horas = sc.nextInt();
            ContratoPorHora contrato = new ContratoPorHora(dataContrato,valorHora,horas);
            trabalhador.addContrato(contrato);
        }

        System.out.println();
        System.out.println("Digite o mes e ano do contrato pata calcula o salario(MM/YYYY):");
        String mesAno = sc.next();
        int mes = Integer.parseInt(mesAno.substring(0,2));
        int ano = Integer.parseInt(mesAno.substring(3));

        sc.close();

    }
}