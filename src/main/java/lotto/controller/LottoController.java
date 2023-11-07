package lotto.controller;

import static lotto.utility.InputValidation.*;
import static lotto.view.OutputView.*;
import static lotto.view.constant.InputConstant.*;

import java.util.Arrays;

import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	private final InputView inputView;
	private final OutputView outputView;
	private final LottoService lottoService;

	public LottoController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
		lottoService = new LottoService();
	}

	public void run() {
		initLottoOrder();
		setWinningResult();
		getResult();
	}

	private void initLottoOrder() {
		inputView.printPriceRequest();
		lottoService.savePrice(getPrice());
		lottoService.purchaseLottos();
		outputView.printLottos(lottoService.findAllLottos());
	}

	public long getPrice() {
		try {
			return validatePrice(inputView.getInput());
		} catch (IllegalArgumentException e) {
			printErrorMessage(e.getMessage());
			return getPrice();
		}
	}

	private void setWinningResult() {
		inputView.printWinningRequest();
		Lotto winningLotto = getWinningNumbers();

		inputView.printBonusRequest();
		int bonusNumber = getBonusNumber(winningLotto);

		lottoService.saveWinningResult(new WinningResult(winningLotto, bonusNumber));
	}

	public Lotto getWinningNumbers() {
		try {
			return new Lotto(validateWinningNumbers(
				Arrays.asList(inputView.getInput().split(INPUT_DELIMITER.getValue()))));
		} catch (IllegalArgumentException e) {
			printErrorMessage(e.getMessage());
			return getWinningNumbers();
		}
	}

	public int getBonusNumber(Lotto winningLotto) {
		try {
			return validateBonusNumber(winningLotto, inputView.getInput());
		} catch (IllegalArgumentException e) {
			printErrorMessage(e.getMessage());
			return getBonusNumber(winningLotto);
		}
	}

	private void getResult() {
		lottoService.saveRankCounts();
		outputView.printResult(lottoService.getRankCounts());
		outputView.printStatistics(lottoService.calculateProfitRate());
	}
}
