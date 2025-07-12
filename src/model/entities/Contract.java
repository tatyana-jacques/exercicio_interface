package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	
	private Integer number;
	private LocalDate localDate;
	private Double totalValue;
	private List <Installment> installments = new ArrayList<>();
	
	public Contract(Integer number, LocalDate localDate, Double totalValue) {
		this.number = number;
		this.localDate = localDate;
		this.totalValue = totalValue;
	}


	public List<Installment> getInstallments() {
		return installments;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	
	
	

}
