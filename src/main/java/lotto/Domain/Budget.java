package lotto.Domain;

import java.util.*;

import camp.nextstep.edu.missionutils.*;
import lotto.Exceptions.Exceptions;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Budget{
	public Integer budget;
	private Integer Purchase_Number;
	private Integer Ticket_Price = 1000;
	
	public Budget() {
		//Validation Budget
		this.budget = try_Budget();
		this.Purchase_Number = budget/Ticket_Price;
	}
	public Integer get_Count() {
		return this.Purchase_Number;
	}
	public Integer get_Cash() {
		return this.budget;
	}
	
	public static Integer try_Budget() {

		String inputbudget="";
		Integer budget = 0;
		Exception b =null;
		Boolean B1,B2 = true;
		while(true) {
			OutputView.Print_Budget_Message();
			inputbudget=InputView.Input_Budget();;
			try {
				budget = Integer.parseInt(inputbudget);
				
			}catch(Exception e) {
				b = e;
				Exceptions.Input_Void(inputbudget,e);
				Exceptions.Input_Valid_Number(inputbudget,e);
			}
			System.out.println(budget);
			B1= Exceptions.Budget_Range_Valid(budget);
			B2= Exceptions.Budget_Positive_Error(budget);
			if(B1&&B2){
				break;

			}
		}
		System.out.println("끝");
		return budget;

	}
	
}
	