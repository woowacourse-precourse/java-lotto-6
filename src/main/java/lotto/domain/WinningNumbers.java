package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.StringChanger;
import lotto.utils.Validator;

public class WinningNumbers {
    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private Lotto firstRankLotto;
    private int bonusNumber = 0;

    public void setFirstRankLotto(List<String> inputNumbers) {
        firstRankLotto = new Lotto(stringToNumbers(inputNumbers));
    }

    public void setBonusNumber(String userInput) {
        bonusNumber = stringToBonusNumber(userInput);
    }

    public Lotto getFirstRankLotto() {
        return new Lotto(new ArrayList<>(firstRankLotto.showNumbers()));
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private List<Integer> stringToNumbers(List<String> inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String inputNumber : inputNumbers) {
            validateNumber(inputNumber);
            numbers.add(stringToInteger(inputNumber));
        }
        return numbers;
    }

    private int stringToBonusNumber(String userInput) {
        validateNumber(userInput);
        int bonusNumber = stringToInteger(userInput);
        validateWinningNumbers(bonusNumber);
        return bonusNumber;
    }

    private void validateWinningNumbers(int bonusNumber) {
        List<Integer> winningNumbers = firstRankLotto.showNumbers();
        winningNumbers.add(bonusNumber);
        Validator.validateUniqueNumbersInRange(winningNumbers, LOTTO_NUMBER_START, LOTTO_NUMBER_END);
    }

    private void validateNumber(String inputNumber) {
        Validator.validateStringIsNumber(inputNumber);
    }

    private int stringToInteger(String inputNumber) {
        return StringChanger.stringToInteger(inputNumber);
    }
}
