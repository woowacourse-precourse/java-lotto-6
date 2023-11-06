package lotto.controller;

import static lotto.exception.ErrorMessage.NOT_INTEGER;

import java.util.Arrays;
import java.util.List;
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

    private static final String LOTTO_SPLIT_SIGNAL = ",";
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

        outputView.printResults(ResultsDto.of(result));
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
                return new Lotto(convertToIntegerList(inputView.enterLotto()));
            } catch (LottoException lottoException) {
                outputView.printError(lottoException.getMessage());
            }
        }
    }

    private List<Integer> convertToIntegerList(final String inputLotto) {
        return Arrays.stream(inputLotto.split(LOTTO_SPLIT_SIGNAL))
                .map(this::convertToInt)
                .toList();
    }

    private AnswerLotto createAnswerLotto(final Lotto mainLotto) {
        while (true) {
            try {
                return AnswerLotto.of(mainLotto, convertToInt(inputView.enterBonusNumber()));
            } catch (LottoException lottoException) {
                outputView.printError(lottoException.getMessage());
            }
        }
    }

}
