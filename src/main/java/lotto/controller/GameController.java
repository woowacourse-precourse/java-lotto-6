package lotto.controller;

import lotto.domain.Cash;
import lotto.domain.Lottos;
import lotto.domain.WinnerLotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.dto.RequestCash;
import lotto.dto.RequestLottos;
import lotto.dto.RequestWinnerLotto;
import lotto.dto.RequestLottoResult;
import lotto.util.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class GameController {

	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();
	private final NumberGenerator numberGenerator;

	public GameController(final NumberGenerator numberGeneratorImp) {
		this.numberGenerator = numberGeneratorImp;
	}

	public void play() {
		gameProcess();
	}


	private void gameProcess() {
		try {
			final Cash cash = depositCash();
			final Lottos lottos = purchaseLotto(cash);
			final WinnerLotto winnerLotto = getWinnerLotto();
			compareLottosWithWinnerLotto(lottos, winnerLotto, cash);
		} catch (final Exception e) {
			outputView.printErrorMessage(e);
		} finally {
			inputView.close();
		}
	}


	private Cash depositCash() {
		try {
			final RequestCash requestCash = inputView.requestCash();
			return Cash.create(requestCash.depositAmount(),
				requestCash.spendAmount());
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			return depositCash();
		} catch (IllegalStateException e) {
			throw e;
		}
	}

	private Lottos purchaseLotto(final Cash cash) {
		final LottoMachine lottoMachine = LottoMachine.create(numberGenerator, cash);
		final RequestLottos requestLottos = lottoMachine.purchaseLottos();
		final Lottos lottos = Lottos.create(requestLottos.createLottoDummy());
		outputView.printPurchasedLottos(lottos);
		return lottos;
	}

	private WinnerLotto getWinnerLotto() {
		try {
			final List<Integer> winnerNumbers = getWinnerNumbers();
			final Integer bonusNumber = getBonusNumber();
			final RequestWinnerLotto requestWinnerLotto = RequestWinnerLotto.of(winnerNumbers,
				bonusNumber);
			return WinnerLotto.create(requestWinnerLotto.winnerNumbers(),
				requestWinnerLotto.bonusNumber());
		} catch (final IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			return getWinnerLotto();
		} catch (final IllegalStateException e) {
			throw e;
		}
	}


	private List<Integer> getWinnerNumbers() {
		try {
			final List<Integer> winnerNumbers = inputView.requestWinnerNumbers();
			return winnerNumbers;
		} catch (final IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			return getWinnerNumbers();
		} catch (final IllegalStateException e) {
			throw e;
		}
	}

	private Integer getBonusNumber() {
		try {
			final Integer bonusNumber = inputView.requestBonusNumber();
			return bonusNumber;
		} catch (final IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			return getBonusNumber();
		} catch (final IllegalStateException e) {
			throw e;
		}
	}


	private void compareLottosWithWinnerLotto(final Lottos lottos, final WinnerLotto winnerLotto,
		final Cash cash) {
		final RequestLottoResult requestLottoResult = lottos.compareWithWinnerLotto(winnerLotto);
		final LottoResult lottoResult = LottoResult.create(requestLottoResult.results());
		lottoResult.getRoundedTotalBenefit(cash.getDepositAmount());
		outputView.printStaticResult(lottoResult, cash);
	}

}






