package lotto.services;

import static lotto.exception.ExceptionHandler.notDivisibleBy1000;
import static lotto.utils.Utils.stringToInteger;

public class Amount {

    public int createAmount(String amount) {
        validateAmount(amount);

        return stringToInteger(amount);
    }

    private void validateAmount(String amount) {
        int convert = stringToInteger(amount);

        if (convert % 1000 != 0) {
            notDivisibleBy1000();
        }
    }
}
