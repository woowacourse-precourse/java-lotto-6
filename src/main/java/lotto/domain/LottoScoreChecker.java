package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.StringChanger;
import lotto.utils.Validator;

public class LottoScoreChecker {
    private final List<Integer> winningNumbers = new ArrayList<>();
    private Lotto winningLotto;

    public void setWinningLotto(List<String> inputNumbers) {
        stringToNumbers(inputNumbers);
        winningLotto = new Lotto(new ArrayList<>(winningNumbers));
    }

    public Lotto getWinningLotto() {
        return new Lotto(new ArrayList<>(winningLotto.showNumbers()));
    }

    private void stringToNumbers(List<String> inputNumbers) {
        for (String inputNumber : inputNumbers) {
            validateNumber(inputNumber);
            winningNumbers.add(stringToInteger(inputNumber));
        }
    }

    private void validateNumber(String inputNumber) {
        Validator.validateStringIsNumber(inputNumber);
    }

    private int stringToInteger(String inputNumber) {
        return StringChanger.stringToInteger(inputNumber);
    }
}
