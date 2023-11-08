package lotto.view;


import static lotto.errorMessage.ExceptionErrorMessage.INPUT_ONLY_NUMBER;
import static lotto.errorMessage.ExceptionErrorMessage.INPUT_ONLY_NUMBER_LOTTO;
import static lotto.errorMessage.ExceptionErrorMessage.PURCHASE_LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Input {
    private static final String comma = ",";
    private static final String ONLY_NUMBER = "^[0-9]+$";
    private static final int Lotto_Price = 1000;

    public static String inputAmount() {
        while (true) {
            try {
                String amount = Console.readLine();
                validateNumber(amount);
                validateLottoPrice(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> inputWinningNumber() {
        while (true) {
            try {
                String winningNumber = Console.readLine();
                validateWinningNumber(winningNumber);
                return numberList(winningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String inputBonusNumber() {
        while (true) {
            try {
                String bonusNumber = Console.readLine();
                validateNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> numberList(String winningNumber) {
        List<String> str = List.of(winningNumber.split(comma));
        List<Integer> winnerNumberList = new ArrayList<>();
        for (String s : str) {
            winnerNumberList.add(Integer.valueOf(s));
        }

        return winnerNumberList;
    }

    public static void validateNumber(String amount) {
        isDigit(amount);
    }

    private static void isDigit(String amount) {
        if (!Pattern.matches(ONLY_NUMBER, amount)) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBER);
        }
    }

    private static void validateWinningNumber(String number) throws IllegalArgumentException {
        for (String str : number.split(",")) {
            if (isNotNumber(str)) {
                throw new IllegalArgumentException(
                        String.format(INPUT_ONLY_NUMBER_LOTTO, ","));
            }
        }
    }

    private static boolean isNotNumber(final String number) {
        return !number.matches("\\d+");
    }

    private static void validateLottoPrice(String str) {
        int amount = Integer.parseInt(str);
        if (amount % Lotto_Price != 0 || amount <= 0) {
            throw new IllegalArgumentException(PURCHASE_LOTTO_PRICE);
        }
    }
}
