package lotto;

import static lotto.Enum.ErrorMessage.NOT_NUMBER_ERROR;
import static lotto.Enum.ErrorMessage.UNIT_ERROR;
import static lotto.Enum.Number.UNIT;

public class Exception {
    public static void checkIfNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR.getMessage());
        }
    }

    public static void checkUnit(int money) {
        int thousand = UNIT.getNumber();
        if (money % thousand != 0) {
            throw new IllegalArgumentException(UNIT_ERROR.getMessage());
        }
    }
}
