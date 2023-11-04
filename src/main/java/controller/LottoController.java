package controller;

import java.util.List;

import model.BuyLotto;
import model.BuyLottoNumber;
import model.Lotto;
import view.InputView;
import view.OutputView;

public class LottoController {
	
	public void buyLotto() {
		BuyLotto buyLotto = new BuyLotto(InputView.getBuyAmount());
		showLottoList(buyLotto.getNumberList());
		getLottoNumber(InputView.getNumberListText());
		getBonusNumber(InputView.getBonusNumberText());
	}

	private void showLottoList(List<BuyLottoNumber> buyLottoNumberList) {
		System.out.println();
		OutputView.showBuyLottoList(buyLottoNumberList);
	}
	
	public static void getLottoNumber(String lottoNumberText) {
		List<Integer> numberList = Lotto.divideText(lottoNumberText);
		try {
			Lotto lotto = new Lotto(numberList);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			getLottoNumber(InputView.getNumberListText());
		}
	}
	
	private void getBonusNumber(Object bonusNumberText) {
		// TODO Auto-generated method stub
		
	}
}
