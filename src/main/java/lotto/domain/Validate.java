package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constants.ErrorMessage;
import lotto.controller.LottoController;

public class Validate {
    private final int MAX_NUMBER = 45;
    private final int MIN_NUMBER = 1;
    private final int MAKE_ERROR_NUMBER = -1;
    private final int SIZE_OF_NUMBERS = 6;
    private final String SEPARATOR = ",";

    // InputPrice
    public long validateInputPrice(String input) {
        long result = -1;
        try {
            result = Long.parseLong(input);
            if (!canDivide(result)) {
                return MAKE_ERROR_NUMBER;
            }
        } catch (NumberFormatException e) {
            errorNotNumber();
            return MAKE_ERROR_NUMBER;
        } catch (IllegalArgumentException e) {
            System.out.print(ErrorMessage.ERROR_MESSAGE);
            System.out.println(ErrorMessage.CAN_NOT_DIVIDE);
            return MAKE_ERROR_NUMBER;
        }

        return result;
    }

    private boolean canDivide(long input) {
        if (input % LottoController.CURRENCY_UNIT != 0 || input < LottoController.CURRENCY_UNIT) {
            throw new IllegalArgumentException();
        }

        if (input % LottoController.CURRENCY_UNIT == 0) {
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
            result.add(MAKE_ERROR_NUMBER);
        } catch (IllegalArgumentException e) {
            System.out.print(ErrorMessage.ERROR_MESSAGE);
            System.out.println(e);
            result.add(MAKE_ERROR_NUMBER);
        } catch (NullPointerException e) {
            System.out.print(ErrorMessage.ERROR_MESSAGE);
            System.out.println(ErrorMessage.CHECK_NUMBER_OF_INPUT);
            result.add(MAKE_ERROR_NUMBER);
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
        if (input.contains(SEPARATOR)) {
            inputNumbers = Arrays
                    .stream(input.split(SEPARATOR))
                    .map(String::trim)
                    .toList();
        }

        if (checkInputListSize(inputNumbers)) {
            return inputNumbers;
        }

        return null;
    }


    private boolean checkInputListSize(List<?> list) {
        int result = list.size();
        if (result == SIZE_OF_NUMBERS) {
            return true;
        }
        return false;
    }

    // BonusNumber
    public int validateBonusNumber(String input, List<Integer> list) {
        int result = MAKE_ERROR_NUMBER;
        try {
            int number = Integer.parseInt(input.trim());

            if (!list.contains(checkRangeOfNumber(number))) {
                return number;
            }
            throw new IllegalArgumentException(ErrorMessage.CHECK_NOT_CONTAIN_NUMBERS.toString());
        } catch (NumberFormatException e) {
            errorNotNumber();
            return MAKE_ERROR_NUMBER;
        } catch (IllegalArgumentException e) {
            System.out.print(ErrorMessage.ERROR_MESSAGE);
            System.out.println(e);
        }

        return result;
    }

    private void errorNotNumber() {
        System.out.print(ErrorMessage.ERROR_MESSAGE);
        System.out.println(ErrorMessage.IS_NOT_NUMBER);
    }
    private int checkRangeOfNumber(int number) {
        int result = number;

        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_CORRECT_RANGE_OF_NUMBER.toString());
        }

        if (number >= MIN_NUMBER && number <= MAX_NUMBER) {
            return result;
        }

        return MAKE_ERROR_NUMBER;
    }
}
