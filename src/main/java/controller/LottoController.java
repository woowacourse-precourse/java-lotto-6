package controller;

import java.util.List;

import dto.BuyLottoBonusDto;
import dto.BuyLottoDto;
import model.BonusNumber;
import model.BuyLottoNumber;
import model.Lotto;
import validators.InputException;
import view.InputView;
import view.OutputView;

public class LottoController {
	
	public void start() {
		BuyLottoDto buyLottoDto = buyLotto(InputView.getBuyAmount());
		Lotto lotto = inputLottoNumber(InputView.getNumberListText());
		BonusNumber bonus = inputBonusNumber(InputView.getBonusNumberText(), lotto);
		
		BuyLottoBonusDto buyLottoBonusDto = new BuyLottoBonusDto(lotto, bonus, buyLottoDto);
		OutputView.showWinStats(buyLottoBonusDto);
		OutputView.showRate(buyLottoBonusDto);
	}

	public static BuyLottoDto buyLotto(String buyAmountText) {
		while(true) {
			try {
				BuyLottoDto buyLottoDto = new BuyLottoDto(buyAmountText);
				showLottoList(buyLottoDto.getNumberList());
				
				return buyLottoDto;
			} catch (Exception e) {
				System.out.println(e);
				buyAmountText = InputView.getBuyAmount();
			}
		}
	}

	private static void showLottoList(List<BuyLottoNumber> buyLottoNumberList) {
		System.out.println();
		OutputView.showBuyLottoList(buyLottoNumberList);
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
				return new BonusNumber(bonusNumberText, lotto);
			} catch (IllegalArgumentException e) {
				System.out.println(e);
				bonusNumberText = InputView.getBonusNumberText();
			}
		}
	}
}
