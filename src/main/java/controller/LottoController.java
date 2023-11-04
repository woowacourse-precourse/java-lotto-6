package controller;

import java.util.List;

import model.BuyAmount;
import model.Lotto;
import view.InputView;

public class LottoController {
	public void buyLotto() {
		BuyAmount buyAmount = new BuyAmount(InputView.getBuyAmount());
		getLottoNumber(buyAmount);
	}

	private void getLottoNumber(BuyAmount buyAmount) {
		List<Integer> numbers = Lotto.getRandomNumberList(buyAmount.getLottoPage());
		Lotto lotto = new Lotto(numbers);
	}
}
