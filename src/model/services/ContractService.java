package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;
import model.service.interfaces.OnlinePaymentService;

public class ContractService {
	
	private OnlinePaymentService paymentService;
	
	
	public ContractService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}


	public void processContract(Contract contract, Integer months) {
		
		double initialInstallmentValue = contract.getTotalValue()/ months;
		
		for (int i = 1; i <= months; i++) {
			LocalDate installDate = contract.getLocalDate().plusMonths(i);
			double installmentInterest = paymentService.interest(initialInstallmentValue, i);
			double installmentPaymentFee = paymentService.paymentFee(initialInstallmentValue + installmentInterest);
			contract.getInstallments().add(new Installment(installDate, initialInstallmentValue + installmentInterest + installmentPaymentFee));
		}
		
	}

}
