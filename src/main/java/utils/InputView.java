package utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.Error;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    private static final String COMMA = ",";
    private static final int WINNING_NUMBER_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;



    public static int inputMoney(String moneyInput) {
        validateNumberFormat(moneyInput);
        int money = Integer.parseInt(moneyInput);

        return money;
    }

    public static List<Integer> inputWinningNumbers(String winningNumber) {
        String[] winningNumbers = winningNumber.split(COMMA, -1);

        List<Integer> validatedNumbers = new ArrayList<>();

        for (int i = 0; i < winningNumbers.length; i++) {
            String number = winningNumbers[i].trim();
            System.out.println(number.length());
            System.out.println("-");

            validateNumberFormat(number);
            validateNumberRange(number);
            validateNameBlank(number);

            validatedNumbers.add(Integer.parseInt(number));
        }

        return validatedNumbers;
    }

    public static int inputBonus(String bonus) {
        validateNumberFormat(bonus);
        validateNumberRange(bonus);

        return Integer.parseInt(bonus);
    }

    private static void validateNumberRange(String number) {
        int num = Integer.parseInt(number);
        if (num < MIN_NUMBER || num > MAX_NUMBER) {
            throw new IllegalArgumentException(Error.ERROR_MSG_NUMBER_RANGE.getMessage());
        }
    }

    private static void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.ERROR_MSG_NUMBER_FORMAT.getMessage());
        }
    }


    private static void validateNameBlank(String number) {
        if (number.isBlank()) {
            throw new IllegalArgumentException(Error.ERROR_MSG_BLANK.getMessage());
        }
    }



}
