package lotto.controller;

import static lotto.util.ConstantMessages.COUNT_TICKET;
import static lotto.util.ConstantMessages.DEPOSIT_TICKET_MONEY;
import static lotto.util.ConstantMessages.INPUT_ANSWER_NUMBER;
import static lotto.view.OutputView.*;
import static lotto.view.InputView.*;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.exception.LottoException;
import lotto.model.Money;
import lotto.model.RandomLottoNumbers;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        printMessage(DEPOSIT_TICKET_MONEY.getMessage());
        Money money = initMoney();

        RandomLottoNumbers randomLotto = createRandomLottoNumbers(money.countTicketQuantity());
        printMessage(randomLotto.toString());

        printMessage(INPUT_ANSWER_NUMBER.getMessage());
        Lotto answerLotto = inputAnswerLotto();

    }

    private Money initMoney() {
        String input = inputTicketQuantity();

        try {
            Money.of(input);
        } catch (LottoException lottoException) {
            printMessage(lottoException.getMessage());
            initMoney();
        }

        return Money.of(input);
    }

    private RandomLottoNumbers createRandomLottoNumbers (Integer count) {
        printMessage(count.toString() + COUNT_TICKET.getMessage());

        return RandomLottoNumbers.of(count);
    }

    private Lotto inputAnswerLotto() {
        List<Integer> inputAnswer;
        Lotto lotto = null;

        try {
            inputAnswer = inputAnswerLottoNumber();
            lotto = new Lotto(inputAnswer);
        } catch (LottoException lottoException) {
            printMessage(lottoException.getMessage());
            inputAnswerLotto();
        }

        return lotto;
    }
}
