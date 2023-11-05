package controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Money;

public class InputValues {

	public int purchaseAmount() {
		
		String amount=Console.readLine();
		Money money=new Money(amount);		
		
		return money.getRefinedAmount();
	}
}
