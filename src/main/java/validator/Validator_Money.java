package validator;

import static model.FixedValues.UNIT_PRICE;

public class Validator_Money {
	
	private int purchase_amount;

	public Validator_Money(String purchase_amount) {
		notEmpty(purchase_amount);
		this.purchase_amount=noChanges(isInteger(purchase_amount));
	}
	
	public int getPurchase_amount() {
		return this.purchase_amount;
	}
	
	private String removeCurrencyUnit(String purchase_amount) {
		String first_unit=purchase_amount.substring(0, 1);
		String last_unit=purchase_amount.substring(purchase_amount.length()-1);
		
		try {isInteger(first_unit);}
		catch(IllegalArgumentException e)
		{purchase_amount=purchase_amount.substring(1);}
		
		try {isInteger(last_unit);}
		catch(IllegalArgumentException e)
		{purchase_amount=purchase_amount.substring(0, purchase_amount.length()-1);}
		
		return purchase_amount;
	}
	
	private void notEmpty(String purchase_amount) {
		if(purchase_amount==null||purchase_amount.equals("")) {
			throw new IllegalArgumentException("[ERROR] 구입금액을 반드시 입력해주세요");
		}
	}
	
	private int isInteger(String purchase_amount) {
		try {
			return Integer.parseInt(purchase_amount);
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 구입금액은 반드시 숫자여야합니다");
		}
	}
	
	private int noChanges(int purchase_amount) {
		if(purchase_amount%UNIT_PRICE!=0) {
			throw new IllegalArgumentException("[ERROR] 거스름돈은 받을 수 없습니다");
		}
		return purchase_amount;
	}
}
