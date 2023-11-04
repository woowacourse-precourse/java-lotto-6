package model;

import validators.InputException;
import view.InputView;

public class BuyAmount {

	private int buyAmount;
	
	public BuyAmount(String buyAmountText) {
		int buyAmount = changeBuyAmount(buyAmountText);
		checkRightAmount(buyAmount);
		this.buyAmount = buyAmount;
	}
	
	private static void againBuyAmount() {
		System.out.println();
		InputView.getBuyAmount();
	}

	private static int changeBuyAmount(String buyAmount) {
		try {
			InputException.checkNumber(buyAmount);
		} catch (Exception e) {
			System.out.println(e);
			againBuyAmount();
		}
		
		return Integer.valueOf(buyAmount);
	}
	
	private void checkRightAmount(int buyAmount) {
		try {
			InputException.checkRightAmount(buyAmount);
		} catch (Exception e) {
			System.out.println(e);
			againBuyAmount();
		}
	}

	public int getBuyAmount() {
		return buyAmount;
	}
}
