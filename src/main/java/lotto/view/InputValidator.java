package lotto.view;

import lotto.common.Range;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    public int checkPurchaseAmount(String input) {
        int amount = checkInteger(input);
        if (amount < 1) {
            throw new IllegalArgumentException();
        }
        return amount;
    }

    public List<Integer> checkLottoNumber(String input) {
        String[] splitNumbers = input.split(",");

        if (splitNumbers.length != Range.SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
        return getNumbers(splitNumbers);
    }

    public int checkBonusNumber(String input) {
        return checkBoundary(input);
    }

    private List<Integer> getNumbers(String[] input) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : input) {
            numbers.add(checkBoundary(number));
        }
        numbers.sort(null);
        return numbers;
    }

    private int checkBoundary(String input) {
        int number = checkInteger(input);
        if (number < Range.START.getValue() || number > Range.END.getValue()) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    private int checkInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
