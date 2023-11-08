package lotto.validation;

import lotto.controller.Controller;
import lotto.util.InputErrorMessage;
import lotto.view.Input;
import lotto.view.Output;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public void checkIsInputNumber(String inputValue) {
        try{
            Integer.parseInt(inputValue);
        } catch(IllegalArgumentException e) {
            System.out.println(InputErrorMessage.NOT_A_NUMBER.getMessage());

            Input input = new Input();
            Output output = new Output();
            Controller controller = new Controller(input, output);
            controller.lottoGame();
        }

    }
    public void ensureCommaDelimiter(String input) {
        if (input.contains(",") == false) {
            throw new IllegalArgumentException(InputErrorMessage.COMMA_DELIMITER.getMessage());
        }
    }

    public void checkDuplicated(String[] numbers) {
        Set<String> selectedNumbers = new HashSet<>();
        for (String number : numbers) {
            selectedNumbers.add(number);
        }
        if (selectedNumbers.size() != 6) {
            throw new IllegalArgumentException(InputErrorMessage.DUPLICATE_NUMBERS.getMessage());
        }
    }

    public void checkNumbersLength(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_VALUE_LENGTH.getMessage());
        }
    }

    public void checkNumbersRange(List<Integer> numbers) {
        numbers.forEach((num) -> {
            checkLottoNumberRange(num);
        });
    }

    public void checkLottoNumberRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_VALUE_RANGE.getMessage());
        }
    }

    public void isNumber(String[] numbers) {
        try {
            for (int i = 0; i < numbers.length; i++) {
                Integer.parseInt(numbers[i]);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(InputErrorMessage.NOT_AN_INTEGER.getMessage());
        }

    }

    public void checkIsBonusNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(InputErrorMessage.NOT_AN_INTEGER.getMessage());
        }
    }
}
