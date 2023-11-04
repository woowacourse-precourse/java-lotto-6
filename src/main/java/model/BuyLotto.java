package model;

import java.util.ArrayList;
import java.util.List;

import controller.LottoController;
import validators.InputException;
import view.InputView;

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
	
	private static void againBuyAmount() {
		System.out.println();
		LottoController.buyLotto();
	}

	private static int changeBuyAmount(String amountText) {
		amountText = amountText.trim();
		amountText = validateBuyAmount(amountText);
		return Integer.valueOf(amountText);
	}
	
	public static String validateBuyAmount(String amountText) {
		while (true) {
	        try {
	            InputException.checkNull(amountText);
	            InputException.checkNumber(amountText);

	            return amountText;
	        } catch (IllegalArgumentException e) {
	            System.out.println(e);
	            System.out.println();
	            amountText = InputView.getBuyAmount();
	        }
	    }
	}

	public int checkRightAmount(int amount) {
		try {
			InputException.checkRightAmount(amount, LOTTO_PRICE);
		} catch (Exception e) {
			System.out.println(e);
			againBuyAmount();
		}
		
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
