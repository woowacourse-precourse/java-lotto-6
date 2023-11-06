package lotto.controller;

import static lotto.exception.ErrorMessage.NOT_INTEGER;

import java.util.regex.Matcher;
import lotto.config.LottoConfig;
import lotto.domain.AnswerLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Money;
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
        final Money money = createMoney();
        final LottoFactory lottoFactory = LottoConfig.getLottoFactory(money);

        outputView.printLottoNumbers(lottoFactory.getLottoNumbers());

        final AnswerLotto answerLotto = createAnswerLotto(createMainLotto());

        final Result result = lottoFactory.calculateResult(answerLotto);

        outputView.printResult(ResultsDto.of(result));
        outputView.printRateOfReturn(result.calculateRateToReturn());

        inputView.close();
    }

    private Money createMoney() {
        while (true) {
            try {
                return Money.of(convertToInt(inputView.enterMoney()));
            } catch (LottoException lottoException) {
                outputView.printError(lottoException.getMessage());
            }
        }
    }

    private int convertToInt(final String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException numberFormatException) {
            throw LottoException.of(NOT_INTEGER);
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
