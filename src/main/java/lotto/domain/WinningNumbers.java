package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.NumberRule;
import lotto.utils.StringChanger;
import lotto.utils.Validator;

public class WinningNumbers {
    private static final int MIN_LOTTO_NUMBER = NumberRule.MIN_LOTTO_NUMBER.getNumber();
    private static final int MAX_LOTTO_NUMBER = NumberRule.MAX_LOTTO_NUMBER.getNumber();
    private static final int NOTHING = 0;

    private final Lotto firstRankLotto;
    private int bonusNumber = NOTHING;

    public WinningNumbers(List<String> inputNumbers) {
        firstRankLotto = new Lotto(toNumbers(inputNumbers));
    }

    public void setBonusNumber(String userInput) {
        bonusNumber = toBonusNumber(userInput);
    }

    public Lotto getFirstRankLotto() {
        return new Lotto(new ArrayList<>(firstRankLotto.getNumbers()));
    }

    public int getBonusNumber() {
        validateWinningNumbersWith(bonusNumber);
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
        Validator.validateUniqueNumbersInRange(winningNumbers, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
    }

    private void validateIsNumber(String inputNumber) {
        Validator.validateIsNumber(inputNumber);
    }

    private int toInteger(String inputNumber) {
        return StringChanger.toInteger(inputNumber);
    }
}
