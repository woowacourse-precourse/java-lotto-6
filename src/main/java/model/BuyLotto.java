package model;

import java.util.ArrayList;
import java.util.List;

import validators.InputException;

public class BuyLotto {

	private static final int LOTTO_PRICE = 1000;
	private int amount;
	private int page;
	private List<BuyLottoNumber> numberList;
	
	public BuyLotto(String amountText) {
		int amount = changeBuyAmount(amountText);
		int page = checkRightAmount(amount);
		
		this.amount = amount;
		this.page = page;
		this.numberList = numberList();
	}

	private static int changeBuyAmount(String amountText) {
		amountText = amountText.trim();
		amountText = validateBuyAmount(amountText);
		return Integer.valueOf(amountText);
	}
	
	public static String validateBuyAmount(String amountText) {
		InputException.checkNull(amountText);
	    InputException.checkNumber(amountText);

	    return amountText;
	}

	public int checkRightAmount(int amount) {
		InputException.checkRightAmount(amount, LOTTO_PRICE);
		
		return amount/LOTTO_PRICE;
	}
	
	private List<BuyLottoNumber> numberList() {
		List<BuyLottoNumber> buyLottoNumberList = new ArrayList<>();
		for(int i = 1; i <= page; i++) {
			BuyLottoNumber buyLottoNumber = new BuyLottoNumber();
			buyLottoNumberList.add(buyLottoNumber);
		}
		return buyLottoNumberList;
	}

	public int getPage() {
		return page;
	}

	public List<BuyLottoNumber> getNumberList() {
		return numberList;
	}
}
