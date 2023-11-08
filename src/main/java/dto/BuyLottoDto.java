package dto;

import java.util.ArrayList;
import java.util.List;

import model.BuyLottoNumber;
import validators.InputException;

public class BuyLottoDto {

	private static final int LOTTO_PRICE = 1000;
	private int amount;
	private int page;
	private List<BuyLottoNumber> numberList;
	
	public BuyLottoDto(String amountText) throws IllegalArgumentException {
		int amount = changeBuyAmount(amountText);
		checkRightAmount(amount);
		
		this.amount = amount;
		this.page = amount/LOTTO_PRICE;
		this.numberList = numberList();
	}

	public int getPage() {
		return page;
	}

	public List<BuyLottoNumber> getNumberList() {
		return numberList;
	}
	
	public int getAmount() {
		return amount;
	}

	public static int changeBuyAmount(String amountText) {
		amountText = amountText.trim();
		amountText = validateBuyAmount(amountText);
		return Integer.valueOf(amountText);
	}
	
	public static String validateBuyAmount(String amountText) {
		InputException.checkNull(amountText);
	    InputException.checkNumber(amountText);

	    return amountText;
	}

	private void checkRightAmount(int amount) {
		InputException.checkRightAmount(amount, LOTTO_PRICE);
	}
	
	private List<BuyLottoNumber> numberList() {
		List<BuyLottoNumber> buyLottoNumberList = new ArrayList<>();
		for(int i = 1; i <= page; i++) {
			BuyLottoNumber buyLottoNumber = new BuyLottoNumber();
			buyLottoNumberList.add(buyLottoNumber);
		}
		return buyLottoNumberList;
	}
}
