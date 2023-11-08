package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.ErrorView;
import lotto.view.InputView;

import java.util.*;

import static lotto.domain.exception.LottoExceptionList.*;

public class NumberGenerator {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT = 6;

    public NumberGenerator() {
    }

    public List<Integer> createLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT));
        try {
            validateNumbersDuplicate(numbers);
            Collections.sort(numbers);
        } catch (IllegalArgumentException e) {
            ErrorView.printErrorMessage(e.getMessage());
            createLottoNumbers();
        }
        return numbers;
    }

    public List<Integer> createWinningNumbers(String numbersInput) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] numberInputSplit = numbersInput.split(",");
        try {
            for (String numberInput : numberInputSplit) {
                validateNumber(numberInput);
                winningNumbers.add(Integer.parseInt(numberInput));
            }
            validateNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            ErrorView.printErrorMessage(e.getMessage());
            createWinningNumbers(InputView.inputWinningNumbers());
        }
        return winningNumbers;
    }

    public int createBonusNumber(List<Integer> winningNumbers, String numberInput) {
        int bonus = 0;
        try {
            validateNumber(numberInput);
            bonus = convertToInt(numberInput);
            validateNumberAlreadyExistsInList(winningNumbers, bonus);
        } catch (IllegalArgumentException e) {
            ErrorView.printErrorMessage(e.getMessage());
            createBonusNumber(winningNumbers, InputView.inputBonusNumber());
        }
        return bonus;
    }

    private void validateNumber(String numberInput) {
        validateNumberExists(numberInput);
        validateNumbersPure(numberInput);
        validateNumbersInRange(convertToInt(numberInput), START_NUMBER, END_NUMBER);
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumbersDuplicate(numbers);
        validateNumbersLength(numbers);
    }

    private void validateNumbersDuplicate(List<Integer> numbers) {
        Set<Integer> numbersDuplicateCheck = new HashSet<>(numbers);
        if (numbersDuplicateCheck.size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATE_ERROR.getMessage());
        }
    }

    private void validateNumbersPure(String number) {
        char temp;
        for (int i = 0; i < number.length(); i++) {
            temp = number.charAt(i);
            if (!Character.isDigit(temp)) {
                throw new IllegalArgumentException(NUMBERS_NOT_PURE_ERROR.getMessage());
            }
        }
    }

    private void validateNumbersInRange(int number, int start, int end) {
        if (number < start || number > end) {
            throw new IllegalArgumentException(NUMBERS_INVALID_ERROR.getMessage());
        }
    }

    private void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBERS_LENGTH_ERROR.getMessage());
        }
    }

    private void validateNumberExists(String number){
        if (number.isEmpty()) {
            throw new IllegalArgumentException(NUMBER_IS_EMPTY.getMessage());
        }
    }

    private void validateNumberAlreadyExistsInList(List<Integer> numbers, int number){
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(NUMBER_ALREADY_EXISTS_IN_LIST_ERROR.getMessage());
        }
    }

    private int convertToInt(String number) {
        return Integer.parseInt(number);
    }
}
