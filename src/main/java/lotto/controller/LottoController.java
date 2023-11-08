package lotto.controller;

import static lotto.util.Convertor.convertListStringToInteger;
import static lotto.util.Parser.parseStringtoList;
import static lotto.util.Validator.*;
import static lotto.view.OutputView.*;
import static lotto.view.InputView.*;

import java.util.List;
import java.util.Optional;
import lotto.Lotto;
import lotto.exception.LottoException;
import lotto.model.LottoResult;
import lotto.model.Money;
import lotto.model.RandomLottoNumbers;

public class LottoController {
    public void run() {
        Money money = initMoney();

        RandomLottoNumbers randomLotto = createRandomLottoNumbers(money.countTicketQuantity());

        Lotto answerLotto = inputAnswerLotto();

        Integer bonusNumber = initBonusNumber(answerLotto);

        LottoResult lottoResult = LottoResult.of(randomLotto.checkResult(answerLotto, bonusNumber));

        checkResultAndReturn(money, lottoResult);
    }

    private Money initMoney() {

        Optional<Money> moneyOptional;

        do {
            printInputMoney();
            moneyOptional = checkMoneyException();
        } while (moneyOptional.isEmpty());

        return moneyOptional.get();
    }

    private Optional<Money> checkMoneyException () {
        Optional<Money> moneyOptional;

        try {
            moneyOptional = Optional.of(Money.of(inputNumber()));
        } catch (LottoException lottoException) {
            printMessage(lottoException.getMessage());
            moneyOptional = Optional.empty();
        }

        return moneyOptional;
    }

    private RandomLottoNumbers createRandomLottoNumbers (Integer count) {
        printTicketQuantity(count.toString());

        RandomLottoNumbers randomLottoNumbers = RandomLottoNumbers.of(count);

        printMessage(randomLottoNumbers.toString());

        return randomLottoNumbers;
    }

    private Lotto inputAnswerLotto() {

        Optional<Lotto> lottoOptional;

        do{
            printInputAnswerLotto();
            lottoOptional = checkLottoException();
        } while (lottoOptional.isEmpty());

        return lottoOptional.get();
    }

    private Optional<Lotto> checkLottoException () {
        Optional<Lotto> lottoOptional;

        try {
            List<String> parseInput = parseStringtoList(inputNumber());
            validateListIsInteger(parseInput);

            lottoOptional = Optional.of(new Lotto(convertListStringToInteger(parseInput)));
        } catch (LottoException lottoException) {
            printMessage(lottoException.getMessage());
            lottoOptional = Optional.empty();
        }

        return lottoOptional;
    }

    private Integer initBonusNumber(Lotto lotto) {

        Optional<Integer> bonusNumberOptional;

        do {
            printInputBonusNumber();
            bonusNumberOptional = checkBonusNumberException(lotto);
        } while (bonusNumberOptional.isEmpty());

        return bonusNumberOptional.get();
    }

    private Optional<Integer> checkBonusNumberException (Lotto lotto) {
        Optional<Integer> bonusNumberOptional;

        try {
            bonusNumberOptional = Optional.of(validateBonusNumber(inputNumber()));
            lotto.checkDuplicateBonusNumber(bonusNumberOptional.get());
        } catch (LottoException lottoException) {
            printMessage(lottoException.getMessage());
            bonusNumberOptional = Optional.empty();
        }

        return bonusNumberOptional.flatMap(Integer::describeConstable);
    }

    private Integer validateBonusNumber (String inputBonusNumber) {
        validateIsInteger(inputBonusNumber);
        validateHasSpace(inputBonusNumber);

        Integer bonusNumber = Integer.parseInt(inputBonusNumber);

        validateNumberMinimumOrMaximum(bonusNumber);

        return bonusNumber;
    }

    private void checkResultAndReturn(Money money, LottoResult lottoResult) {
        printLottoResult(lottoResult);

        printReturn(
                money.calculateTotalReturn(
                        lottoResult.calculateTotal()
                )
        );
    }
}
