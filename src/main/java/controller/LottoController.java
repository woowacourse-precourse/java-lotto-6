package controller;

import java.util.List;

import model.BuyLotto;
import model.BuyLottoNumber;
import view.InputView;
import view.OutputView;

public class LottoController {
	
	public void buyLotto() {
		BuyLotto buyLotto = new BuyLotto(InputView.getBuyAmount());
		showLottoList(buyLotto.getNumberList());
		getNumberList(InputView.getNumberListText());
	}

	private void showLottoList(List<BuyLottoNumber> buyLottoNumberList) {
		System.out.println();
		OutputView.showBuyLottoList(buyLottoNumberList);
	}
	
	private void getNumberList(String numberListText) {
		
	}
}
