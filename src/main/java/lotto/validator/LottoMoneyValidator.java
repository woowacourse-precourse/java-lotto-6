package lotto.validator;

import lotto.constant.ErrorMessages;

public class LottoMoneyValidator {
    public static void validate(String lottoMoneyInput) {
        isNumeric(lottoMoneyInput);
        isOverThousands(lottoMoneyInput);
        isThousands(lottoMoneyInput);
    }

    private static void isNumeric(String lottoMoneyInput) {
        if (!lottoMoneyInput.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(ErrorMessages.NOT_NUMBER.getMessage());
        }
    }

    private static void isOverThousands(String lottoMoneyInput) {
        if (Integer.parseInt(lottoMoneyInput) < 1000) {
            throw new IllegalArgumentException(ErrorMessages.NOT_ENOUGH_MONEY.getMessage());
        }
    }

    private static void isThousands(String lottoMoneyInput) {
        if (Integer.parseInt(lottoMoneyInput) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.NOT_THOUSAND.getMessage());
        }
    }

}
