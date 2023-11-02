package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.RandomNumberGenerator;
import lotto.domain.Result;
import lotto.dto.ResultsDto;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final LottoFactory lottoFactory = getLottoFactory();
        outputView.printLottoNumbers(lottoFactory.getLottoNumbers());

        final Lotto answerLotto = getAnswerLotto();

        final Result result = getResult(lottoFactory, answerLotto);

        outputView.printResult(ResultsDto.of(result));
        outputView.printRateOfReturn(result.calculateRate());
    }

    private LottoFactory getLottoFactory() {
        while (true) {
            try {
                return LottoFactory.create(new RandomNumberGenerator(), inputView.enterMoney());
            } catch (LottoException lottoException) {
                outputView.printError(lottoException.getMessage());
            }
        }
    }

    private Lotto getAnswerLotto() {
        while (true) {
            try {
                return new Lotto(inputView.enterLotto());
            } catch (LottoException lottoException) {
                outputView.printError(lottoException.getMessage());
            }
        }
    }

    private Result getResult(final LottoFactory lottoFactory, final Lotto answerLotto) {
        while (true) {
            try {
                int bonusNumber = inputView.enterBonusNumber();
                return Result.of(lottoFactory.calculateResult(answerLotto, bonusNumber));
            } catch (LottoException lottoException) {
                outputView.printError(lottoException.getMessage());
            }
        }
    }

}
