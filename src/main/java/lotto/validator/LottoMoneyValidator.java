package lotto.validator;

import static lotto.constant.Constants.LOTTO_PRICE;

import lotto.constant.ErrorMessages;

public class LottoMoneyValidator {
    public static void validate(String lottoMoneyInput) {
        isNumeric(lottoMoneyInput);
        isOverThousands(lottoMoneyInput);
        isThousands(lottoMoneyInput);
    }

    private static void isNumeric(String lottoMoneyInput) {
        if (!lottoMoneyInput.matches("^[0-9]*$")) {
            System.out.println(ErrorMessages.NOT_NUMBER.getMessage());
            throw new NumberFormatException(ErrorMessages.NOT_NUMBER.getMessage());
        }
    }

    private static void isOverThousands(String lottoMoneyInput) {
        if (Integer.parseInt(lottoMoneyInput) < LOTTO_PRICE) {
            System.out.println(ErrorMessages.NOT_ENOUGH_MONEY.getMessage());
            throw new IllegalArgumentException(ErrorMessages.NOT_ENOUGH_MONEY.getMessage());
        }
    }

    private static void isThousands(String lottoMoneyInput) {
        if (Integer.parseInt(lottoMoneyInput) % LOTTO_PRICE != 0) {
            System.out.println(ErrorMessages.NOT_THOUSAND.getMessage());
            throw new IllegalArgumentException(ErrorMessages.NOT_THOUSAND.getMessage());
        }
    }

}
