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
    private static final String NO_LOTTO = Error.NO_LOTTO.getMessage();
    private Lotto firstRankLotto;
    private int bonusNumber = NOTHING;

    public void setFirstRankLotto(List<String> inputNumbers) {
        firstRankLotto = new Lotto(stringToNumbers(inputNumbers));
    }

    public void setBonusNumber(String userInput) {
        bonusNumber = stringToBonusNumber(userInput);
    }

    public Lotto getFirstRankLotto() {
        try {
            return new Lotto(new ArrayList<>(firstRankLotto.getNumbers()));
        } catch (NullPointerException e) {
            System.out.println(NO_LOTTO);
        }
        return new Lotto(new ArrayList<>());
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
        List<Integer> winningNumbers = firstRankLotto.getNumbers();
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
