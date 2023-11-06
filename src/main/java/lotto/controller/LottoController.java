package lotto.controller;

import lotto.config.LottoConfig;
import lotto.convertor.Convertor;
import lotto.domain.AnswerLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.dto.ResultsDto;
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
        final LottoFactory lottoFactory = LottoConfig.getLottoFactory(createMoney());

        outputView.printLottoNumbers(lottoFactory.getLottoNumbers());

        final AnswerLotto answerLotto = createAnswerLotto(createMainLotto());
        final Result result = lottoFactory.calculateResult(answerLotto);

        outputView.printResults(ResultsDto.from(result));
        outputView.printRateOfReturn(result.calculateRateToReturn());

        inputView.close();
    }

    private Money createMoney() {
        while (true) {
            try {
                return Money.from(Convertor.toInt(inputView.enterMoney()));
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printError(illegalArgumentException.getMessage());
            }
        }
    }

    private Lotto createMainLotto() {
        while (true) {
            try {
                return new Lotto(Convertor.toIntegerList(inputView.enterLotto()));
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printError(illegalArgumentException.getMessage());
            }
        }
    }

    private AnswerLotto createAnswerLotto(final Lotto mainLotto) {
        while (true) {
            try {
                return AnswerLotto.of(mainLotto, Convertor.toInt(inputView.enterBonusNumber()));
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printError(illegalArgumentException.getMessage());
            }
        }
    }

}
