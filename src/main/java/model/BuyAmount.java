package model;

import validators.InputException;
import view.InputView;

public class BuyAmount {

	private int buyAmount;
	private int lottoPage;
	
	public BuyAmount(String buyAmountText) {
		int buyAmount = changeBuyAmount(buyAmountText);
		int lottoPage = checkRightAmount(buyAmount);
		this.buyAmount = buyAmount;
		this.lottoPage = lottoPage;
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
	
	private int checkRightAmount(int buyAmount) {
		try {
			InputException.checkRightAmount(buyAmount);
		} catch (Exception e) {
			System.out.println(e);
			againBuyAmount();
		}
		
		return buyAmount/1000;
	}

	public int getBuyAmount() {
		return buyAmount;
	}

	public int getLottoPage() {
		return lottoPage;
	}
}
