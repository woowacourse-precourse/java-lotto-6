package lotto.controller;

import lotto.model.RandomLottoGenerator;
import lotto.model.Lotto;

import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.Lotto;

public class LottoController {
	
	private final InputView inputView;
	private final OutputView outputView;
	
	private int lottoAmount; // purchaseAmount/1000;
	private final int LOTTO_PRICE = 1000;
	private int purchaseAmount;
	
	
	public LottoController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}
	
	public void buy() {
		lottoAmount = (purchaseAmount = getPurchaseAmount())/LOTTO_PRICE;
		RandomLottoGenerator randomLotto = new RandomLottoGenerator();
		while(lottoAmount-- > 0) {
			Lotto lotto = new Lotto(randomLotto.lottoNumber());
		}
	}

	private int getPurchaseAmount() {
		outputView.printPurchaseAmount();
		String Amount = inputView.getPurchaseAmount();
		return Integer.parseInt(Amount);
	}
}
