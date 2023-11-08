package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningStatistic;
import lotto.domain.vo.LottoNumber;
import lotto.domain.vo.LottoNumbers;
import lotto.exception.LottoException;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
	private final InputView input;
	private final OutputView output;
	private final LottoService lottoService;

	public GameController(InputView inputView, OutputView outputView, LottoService lottoService) {
		this.input = inputView;
		this.output = outputView;
		this.lottoService = lottoService;
	}

	public void runGame() {
		buyLottoTickets();
		setLottoResult(winningNumbers());
		getWinningStatistic();
	}

	private void buyLottoTickets() {
		while (true) {
			try {
				int inputAmount = input.inputAmount();
				Lotto lotto = lottoService.purchaseLotto(inputAmount);
				output.printLineSpace();
				output.printLottoContent(lotto);
				break;
			} catch (LottoException ignored) {
			}
		}
	}

	private void setLottoResult(LottoNumbers winnings) {
		output.printLineSpace();
		while (true) {
			try {
				LottoNumber bonusNumber = LottoNumber.valueOf(input.inputBonusNumber());
				lottoService.setWinningNumbers(winnings, bonusNumber);
				output.printLineSpace();
				break;
			} catch (LottoException ignored) {
			}
		}
	}

	private LottoNumbers winningNumbers() {
		try {
			return new LottoNumbers(input.inputWinningNumbers());
		} catch (LottoException ignored) {
			return winningNumbers();
		}
	}

	private void getWinningStatistic() {
		WinningStatistic winningStatistic = lottoService.getWinningStatistic();
		output.printResultContent(winningStatistic);
	}
}
