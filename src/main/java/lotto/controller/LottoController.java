package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import lotto.dto.requset.Price;
import lotto.dto.requset.WinningBonusNumber;
import lotto.dto.response.WinningResult;
import lotto.service.Calculation;
import lotto.view.Exception;
import lotto.view.Output;

public class LottoController implements Input {

	private Output lottoView;
	private Exception exceptionView;

	private Calculation lottoService;

	private final WinningBonusNumber winningBonusNumber = new WinningBonusNumber();

	public LottoController(Output lottoView, Exception exceptionView, Calculation lottoService) {
		this.lottoView = lottoView;
		this.exceptionView = exceptionView;
		this.lottoService = lottoService;
	}

	@Override
	public void purchasePrice() {
		lottoView.Intro();
		try {
			Price price = new Price(readLine());
			lottoView.PurchaseCompleted(lottoService.createLotto(price.getPrice()));
		} catch (IllegalArgumentException e) {
			exceptionView.PriceException(e);
			purchasePrice();
		}
	}

	@Override
	public void winningNumber() {
		lottoView.WinningNumber();
		try {
			winningBonusNumber.setWinningNumber(readLine());
		} catch (IllegalArgumentException e) {
			exceptionView.PriceException(e);
			winningNumber();
		}
	}

	@Override
	public void bonusNumber() {
		lottoView.BonusNumber();
		try {
			winningBonusNumber.setBonusNumber(readLine());
			WinningResult winningResult = lottoService.winningCalculation(winningBonusNumber);
			lottoView.result(winningResult);
		} catch (IllegalArgumentException e) {
			exceptionView.PriceException(e);
			bonusNumber();
		}
	}

}
