package controller;

import java.util.ArrayList;
import java.util.Comparator;
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
		buyLottoBonusDto.WinStats();
		OutputView.showWinStats(buyLottoBonusDto);
		buyLottoBonusDto.getRate();
		OutputView.showRate(buyLottoBonusDto);
	}

	public static BuyLottoDto buyLotto(String buyAmountText) {
		while(true) {
			try {
				int buyAmount = BuyLottoDto.changeBuyAmount(buyAmountText);
				BuyLottoDto buyLottoDto = new BuyLottoDto(buyAmount);
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
		for(BuyLottoNumber buyLottoNumber : buyLottoNumberList) {
			List<Integer> numbers = new ArrayList<>(buyLottoNumber.getNumbers());
			numbers.sort(Comparator.naturalOrder());
		}
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
				BonusNumber bonus = new BonusNumber(bonusNumberText, lotto);
					
				return bonus;
			} catch (IllegalArgumentException e) {
				System.out.println(e);
				bonusNumberText = InputView.getBonusNumberText();
			}
		}
	}
}
