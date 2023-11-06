package service;

import static util.ErrorMessage.AMOUNT_MUST_BE_DIVIDED_BY_PRICE;
import static util.ErrorMessage.ONLY_INPUT_NUMBER;
import static util.LottoValidationValue.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Console;

public class UserInputService {

    public static int amount() {
        return checkIsDivideByLottoPrice(checkIsNumber());
    }

    private static String input() {
        return Console.readLine();
    }

    private static int checkIsNumber() {
        while (true) {
            try {
                return Integer.parseInt(input());
            } catch (IllegalArgumentException e) {
                System.out.println(ONLY_INPUT_NUMBER.get());
            }
        }
    }

    private static int checkIsDivideByLottoPrice(int input) {
        if (input % LOTTO_PRICE.get() != 0) {
            System.out.println(AMOUNT_MUST_BE_DIVIDED_BY_PRICE.get());
            return amount();
        }

        return input / LOTTO_PRICE.get();
    }
}
