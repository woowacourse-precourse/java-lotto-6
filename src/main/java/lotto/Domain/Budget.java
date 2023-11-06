package lotto.Domain;

import java.util.*;

import camp.nextstep.edu.missionutils.*;

public class Budget{
	private Integer budget;
	private Integer Purchase_Number;
	private Integer Ticket_Price = 1000;
	
	public Budget(final Integer Cash) {
		//Validation Budget
		this.budget = Cash;
		this.Purchase_Number = Cash/Ticket_Price;
	}
	public Integer get_Count() {
		return this.Purchase_Number;
	}
	public Integer get_Cash() {
		return this.budget;
	}
		
	
}
	