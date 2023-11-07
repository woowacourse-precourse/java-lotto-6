package lotto.exception;

import lotto.constant.Phrases;
import lotto.view.OutputAboutException;

import java.util.List;

public abstract class CommonException {
    public void isNotNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(Phrases.notNumberExceptionPhrase);
        }
    }

    public void emptyInput(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException(Phrases.isEmptyData);
        }
    }

    public void overRange(String number) {
        int testNumber = Integer.parseInt(number);
        if (testNumber < 1 || testNumber > 45) {
            throw new IllegalArgumentException(Phrases.wrongRangeNumber);
        }
    }

    public void overRange(List<Integer> numbers) {
        for (int testNumber : numbers) {
            if (testNumber < 1 || testNumber > 45) {
                throw new IllegalArgumentException(Phrases.wrongRangeNumber);
            }
        }
    }
}
