package lotto.controller;

import lotto.config.LottoConfig;
import lotto.domain.AnswerLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
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
        final LottoFactory lottoFactory = createLottoFactory();
        outputView.printLottoNumbers(lottoFactory.getLottoNumbers());

        final AnswerLotto answerLotto = createAnswerLotto(createMainLotto());

        final Result result = lottoFactory.calculateResult(answerLotto);

        outputView.printResult(ResultsDto.of(result));
        outputView.printRateOfReturn(result.calculateRateToReturn());

        inputView.close();
    }

    private LottoFactory createLottoFactory() {
        while (true) {
            try {
                return LottoConfig.getLottoFactory(inputView.enterMoney());
            } catch (LottoException lottoException) {
                outputView.printError(lottoException.getMessage());
            }
        }
    }

    private Lotto createMainLotto() {
        while (true) {
            try {
                return new Lotto(inputView.enterLotto());
            } catch (LottoException lottoException) {
                outputView.printError(lottoException.getMessage());
            }
        }
    }

    private AnswerLotto createAnswerLotto(final Lotto mainLotto) {
        while (true) {
            try {
                return AnswerLotto.of(mainLotto, inputView.enterBonusNumber());
            } catch (LottoException lottoException) {
                outputView.printError(lottoException.getMessage());
            }
        }
    }

}
