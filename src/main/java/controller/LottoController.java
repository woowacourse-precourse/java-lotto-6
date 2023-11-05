package controller;

import java.util.List;

import model.BonusNumber;
import model.BuyLotto;
import model.BuyLottoNumber;
import model.Lotto;
import validators.InputException;
import view.InputView;
import view.OutputView;

public class LottoController {
	
	public void start() {
		BuyLotto buyLotto = buyLotto();
		choiceNumber();
	}

	public static BuyLotto buyLotto() {
		while(true) {
			try {
				BuyLotto buyLotto = new BuyLotto(InputView.getBuyAmount());
				showLottoList(buyLotto.getNumberList());
				
				return buyLotto;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private static void showLottoList(List<BuyLottoNumber> buyLottoNumberList) {
		System.out.println();
		OutputView.showBuyLottoList(buyLottoNumberList);
	}
	
	private static void choiceNumber() {
		Lotto lotto = inputLottoNumber(InputView.getNumberListText());
		BonusNumber bonus = inputBonusNumber(InputView.getBonusNumberText(), lotto);
	}
	
	public static Lotto inputLottoNumber(String lottoNumberText) {
		while(true) {
			try {
				InputException.checkNull(lottoNumberText);
				List<Integer> numberList = Lotto.changeNumberList(lottoNumberText);
				
				return new Lotto(numberList);
			} catch (IllegalArgumentException e) {
				System.out.println(e);
				lottoNumberText = InputView.getNumberListText();
			}
		}
	}

	private static BonusNumber inputBonusNumber(String bonusNumberText, Lotto lotto) {
		while(true) {
			try {
				InputException.checkNull(bonusNumberText);
				int bonusNumber = BonusNumber.changeToNumber(bonusNumberText);
				BonusNumber bonus = new BonusNumber(bonusNumber);
					
				return bonus;
			} catch (IllegalArgumentException e) {
				System.out.println(e);
				bonusNumberText = InputView.getBonusNumberText();
			}
		}
	}
}
