package lotto.validation;

import lotto.exception.InvalidThousandWonFormatException;

public class ValidateThousandWonFormat {
    public static void validate(String inputValue) {
        int inputMoney = Integer.parseInt(inputValue);
        if (inputMoney % 1000 != 0 || inputMoney == 0) {
            throw new InvalidThousandWonFormatException();
        }
    }
}
