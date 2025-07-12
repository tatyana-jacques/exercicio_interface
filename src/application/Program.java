package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		double valor = sc.nextDouble();
		
		Contract contract = new Contract(numero, date, valor);
		
		
		System.out.print("Entre com o número de parcelas: ");
		int parcelas = sc.nextInt();
		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contract, parcelas);
		
		System.out.println("Parcelas: ");
		for(Installment i: contract.getInstallments()) {
			System.out.println(i);
		}
		
		
		
		
		sc.close();

	}

}
