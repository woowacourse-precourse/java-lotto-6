package lotto.controller;

import static lotto.util.ConstantMessages.COUNT_TICKET;
import static lotto.util.ConstantMessages.DEPOSIT_TICKET_MONEY;
import static lotto.util.ConstantMessages.INPUT_ANSWER_NUMBER;
import static lotto.util.ConstantMessages.INPUT_BONUS_NUMBER;
import static lotto.util.Validator.*;
import static lotto.view.OutputView.*;
import static lotto.view.InputView.*;

import java.util.List;
import lotto.Lotto;
import lotto.exception.LottoException;
import lotto.model.LottoResult;
import lotto.model.Money;
import lotto.model.RandomLottoNumbers;

public class LottoController {
    public void run() {
        printMessage(DEPOSIT_TICKET_MONEY.getMessage());
        Money money = initMoney();

        RandomLottoNumbers randomLotto = createRandomLottoNumbers(money.countTicketQuantity());
        printMessage(randomLotto.toString());

        printMessage(INPUT_ANSWER_NUMBER.getMessage());
        Lotto answerLotto = inputAnswerLotto();

        printMessage(INPUT_BONUS_NUMBER.getMessage());
        Integer bonusNumber = initBonusNumber(answerLotto);

        LottoResult lottoResult = LottoResult.of(randomLotto.checkResult(answerLotto, bonusNumber));
        printLottoResult(lottoResult);
        checkResultAndReturn(money, lottoResult);
    }

    private Money initMoney() {
        String input = inputNumber();

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

    private Integer initBonusNumber(Lotto lotto) {
        String inputBonusNumber = inputNumber();
        Integer bonusNumber = 0;

        try {
            bonusNumber = validateBonusNumber(inputBonusNumber);

            lotto.checkDuplicateBonusNumber(bonusNumber);
        } catch (LottoException lottoException) {
            printMessage(lottoException.getMessage());
            initBonusNumber(lotto);
        }

        return bonusNumber;
    }

    private Integer validateBonusNumber (String inputBonusNumber) {
        validateIsInteger(inputBonusNumber);
        validateHasSpace(inputBonusNumber);

        Integer bonusNumber = Integer.parseInt(inputBonusNumber);

        validateNumberMinimumOrMaximum(bonusNumber);

        return bonusNumber;
    }

    private void checkResultAndReturn(Money money, LottoResult lottoResult) {
        printReturn(
                money.calculateTotalReturn(
                        lottoResult.calculateTotal()
                )
        );
    }
}
