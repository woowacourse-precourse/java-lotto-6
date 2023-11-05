package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Money {

	private static int purchase_amount_refined;
	private static final int UNIT_AMOUNT=1000;
	
	//private static final controller.InputValues RE_INPUT=new InputValues();
	
	public Money() {
		while(true) {
			try {
				String purchase_amount=Console.readLine();
				validate(purchase_amount);
				break;
			} catch(IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int getRefinedAmount() {
		return purchase_amount_refined;
	}
	
	private void validate(String purchase_amount) {
		String result;
		result=flexibleAcceptance(purchase_amount);
		notEmpty(result);
		result=removeCurrencyUnit(result);
		naN(result);
		
		noChanges();
	}
	
	private String flexibleAcceptance(String purchase_amount) {
		purchase_amount=purchase_amount.replace(" ", "").replace(".", "").replace(",", "");
		return purchase_amount;
	}
	
	private String removeCurrencyUnit(String purchase_amount) {
		String first_unit=purchase_amount.substring(0, 1);
		String last_unit=purchase_amount.substring(purchase_amount.length()-1);
		
		try {naN(first_unit);}
		catch(IllegalArgumentException e)
		{purchase_amount=purchase_amount.substring(1);}
		
		try {naN(last_unit);}
		catch(IllegalArgumentException e)
		{purchase_amount=purchase_amount.substring(0, purchase_amount.length()-1);}
		
		return purchase_amount;
	}
	
	private void notEmpty(String purchase_amount) {
		if(purchase_amount==null||purchase_amount.equals("")) {
			//treatEmpty();
			throw new IllegalArgumentException("[ERROR] 구입금액을 반드시 입력해주세요");
		}
	}
	
	/*private void treatEmpty() {
		try {
			throw new IllegalArgumentException("[ERROR] 구입금액을 반드시 입력해주세요");
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
	}*/
	
	private void naN(String purchase_amount) {
		try {
			purchase_amount_refined=Integer.parseInt(purchase_amount);
		} catch(NumberFormatException e) {
			//treatNaN();
			throw new IllegalArgumentException("[ERROR] 구입금액은 반드시 숫자여야합니다");
		}
	}
	
	/*private void treatNaN() {
		try {
			throw new IllegalArgumentException("[ERROR] 구입금액은 반드시 숫자여야합니다");
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
	}*/
	
	private void noChanges() {
		if(purchase_amount_refined%UNIT_AMOUNT!=0) {
			//treatChanges();
			throw new IllegalArgumentException("[ERROR] 거스름돈은 받을 수 없습니다");
		}
	}
	
	/*private void treatChanges() {
		try {
			throw new IllegalArgumentException("[ERROR] 거스름돈은 받을 수 없습니다");
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
	}*/
}
