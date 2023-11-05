package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.Error;
import lotto.constants.Number;
import lotto.utils.StringChanger;
import lotto.utils.Validator;

public class WinningNumbers {
    private static final int LOTTO_NUMBER_START = Number.MIN_LOTTO_NUMBER.getNumber();
    private static final int LOTTO_NUMBER_END = Number.MAX_LOTTO_NUMBER.getNumber();
    private static final int NOTHING = 0;
    private static final Error NO_LOTTO = Error.NO_LOTTO;
    private Lotto firstRankLotto;
    private int bonusNumber = NOTHING;

    public void setFirstRankLotto(List<String> inputNumbers) {
        firstRankLotto = new Lotto(toNumbers(inputNumbers));
    }

    public void setBonusNumber(String userInput) {
        bonusNumber = toBonusNumber(userInput);
    }

    public Lotto getFirstRankLotto() {
        try {
            return new Lotto(new ArrayList<>(firstRankLotto.getNumbers()));
        } catch (NullPointerException e) {
            System.out.println(NO_LOTTO.getMessage());
        }
        return new Lotto(new ArrayList<>());
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private List<Integer> toNumbers(List<String> inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String inputNumber : inputNumbers) {
            validateIsNumber(inputNumber);
            numbers.add(toInteger(inputNumber));
        }
        return numbers;
    }

    private int toBonusNumber(String userInput) {
        validateIsNumber(userInput);
        int bonusNumber = toInteger(userInput);
        validateWinningNumbersWith(bonusNumber);
        return bonusNumber;
    }

    private void validateWinningNumbersWith(int bonusNumber) {
        List<Integer> winningNumbers = firstRankLotto.getNumbers();
        winningNumbers.add(bonusNumber);
        Validator.validateUniqueNumbersInRange(winningNumbers, LOTTO_NUMBER_START, LOTTO_NUMBER_END);
    }

    private void validateIsNumber(String inputNumber) {
        Validator.validateIsNumber(inputNumber);
    }

    private int toInteger(String inputNumber) {
        return StringChanger.toInteger(inputNumber);
    }
}
