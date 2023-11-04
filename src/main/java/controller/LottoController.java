package controller;

import model.BuyAmount;
import view.InputView;

public class LottoController {
	public void buyLotto() {
		BuyAmount buyAmount = new BuyAmount(InputView.getBuyAmount());
	}
}
