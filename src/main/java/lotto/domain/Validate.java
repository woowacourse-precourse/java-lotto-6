package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constants.ErrorMessage;

public class Validate {
    // InputPrice
    public long validateInputPrice(String input) {
        long result;
        try {
            result = Long.parseLong(input);
            if (!canDivide(result)) {
                return 0;
            }
        } catch (NumberFormatException e) {
            errorNotNumber();
            return 0;
        } catch (IllegalArgumentException e) {
            System.out.print(ErrorMessage.ERROR_MESSAGE);
            System.out.println(ErrorMessage.CAN_NOT_DIVIDE);
            return 0;
        }

        return result;
    }

    private boolean canDivide(long input) {
        if (input % 1000 != 0 || input == 0) {
            throw new IllegalArgumentException();
        }

        if (input % 1000 == 0) {
            return true;
        }

        return false;
    }

    // WinnerNumbers
    public List<Integer> validateWinnerNumbers(String input) {
        List<Integer> result = new ArrayList<>();
        List<String> inputNumbers = getStrings(input);
        try {
            checkDuplicateNumber(result, inputNumbers);
        } catch (NumberFormatException e) {
            errorNotNumber();
            result.add(-1);
        } catch (IllegalArgumentException e) {
            System.out.print(ErrorMessage.ERROR_MESSAGE);
            System.out.println(e);
            result.add(-1);
        } catch (NullPointerException e) {
            System.out.print(ErrorMessage.ERROR_MESSAGE);
            System.out.println(ErrorMessage.CHECK_NUMBER_OF_INPUT);
            result.add(-1);
        }

        return result;
    }

    private void checkDuplicateNumber(List<Integer> result, List<String> inputNumbers) {
        for (String str : inputNumbers) {
            int number = Integer.parseInt(str);
            if (result.contains(checkRangeOfNumber(number))) {
                throw new IllegalArgumentException(String.valueOf(ErrorMessage.CHECK_NUMBER_OF_DUPLICATE));
            }
            result.add(Integer.parseInt(str));
        }
    }

    private List<String> getStrings(String input) {
        List<String> inputNumbers = new ArrayList<>();
        if (input.contains(",")) {
            inputNumbers = Arrays
                    .stream(input.split(","))
                    .map(String::trim)
                    .toList();
        }

        if (checkInputListSize(inputNumbers)) {
            return inputNumbers;
        }

        return null;
    }

    private int checkRangeOfNumber(int number) {
        int result = number;

        if (number >= 1 && number <= 45) {
            return result;
        }

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_CORRECT_RANGE_OF_NUMBER.toString());
        }

        return -1;
    }

    private boolean checkInputListSize(List<?> list) {
        int result = list.size();
        if (result == 6) {
            return true;
        }
        return false;
    }

    private void errorNotNumber() {
        System.out.print(ErrorMessage.ERROR_MESSAGE);
        System.out.println(ErrorMessage.IS_NOT_NUMBER);
    }
}
