package lotto;

import controller.InputValues;

public class Money {

	private int purchase_amount;
	private static final int UNIT_AMOUNT=1000;
	
	private static final controller.InputValues RE_INPUT=new InputValues();
	
	public Money(String purchase_amount) {
		validate(purchase_amount);
	}
	
	public int getRefinedAmount() {
		return this.purchase_amount;
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
			treatEmpty();
		}
	}
	
	private void treatEmpty() {
		try {
			throw new IllegalArgumentException("[ERROR] 구입금액을 반드시 입력해주세요");
		} catch(IllegalArgumentException e) {
			RE_INPUT.purchaseAmount();
		}
	}
	
	private void naN(String purchase_amount) {
		try {
			this.purchase_amount=Integer.parseInt(purchase_amount);
		} catch(NumberFormatException e) {
			treatNaN();
		}
	}
	
	private void treatNaN() {
		try {
			throw new IllegalArgumentException("[ERROR] 구입금액은 반드시 숫자여야합니다");
		} catch(IllegalArgumentException e) {
			RE_INPUT.purchaseAmount();
		}
	}
	
	private void noChanges() {
		if(this.purchase_amount%UNIT_AMOUNT!=0) {
			treatChanges();
		}
	}
	
	private void treatChanges() {
		try {
			throw new IllegalArgumentException("[ERROR] 거스름돈은 받을 수 없습니다");
		} catch(IllegalArgumentException e) {
			RE_INPUT.purchaseAmount();
		}
	}
}
