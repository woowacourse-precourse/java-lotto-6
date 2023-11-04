package controller;

import java.util.List;

import model.BonusNumber;
import model.BuyLotto;
import model.BuyLottoNumber;
import model.Lotto;
import view.InputView;
import view.OutputView;

public class LottoController {
	
	public void start() {
		buyLotto();
		choiceNumber();
	}

	public static void buyLotto() {
		BuyLotto buyLotto = new BuyLotto(InputView.getBuyAmount());
		showLottoList(buyLotto.getNumberList());
	}

	private static void showLottoList(List<BuyLottoNumber> buyLottoNumberList) {
		System.out.println();
		OutputView.showBuyLottoList(buyLottoNumberList);
	}
	
	private static void choiceNumber() {
		Lotto lotto = inputLottoNumber(InputView.getNumberListText());
		BonusNumber bonus = inputBonusNumber(InputView.getBonusNumberText());
	}
	
	public static Lotto inputLottoNumber(String lottoNumberText) {
		while(true) {
			try {
				List<Integer> numberList = Lotto.divideText(lottoNumberText);
				Lotto lotto = new Lotto(numberList);
				
				return lotto;
			} catch (IllegalArgumentException e) {
				System.out.println(e);
				return inputLottoNumber(InputView.getNumberListText());
			}
		}
	}
	
	private static BonusNumber inputBonusNumber(String bonusNumberText) {
		while(true) {
			try {
				BonusNumber.validateBonusNumber(bonusNumberText);
				int bonusNumber = BonusNumber.changeToNumber(bonusNumberText);
				BonusNumber bonus = new BonusNumber(bonusNumber);
				
				return bonus;
			} catch (IllegalArgumentException e) {
				System.out.println(e);
				System.out.println();
				
				return inputBonusNumber(InputView.getBonusNumberText());
			}
		}
	}
}
