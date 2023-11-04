package lotto;

import static lotto.ErrorMessage.DUPLICATE_NUMBER_ERROR_MESSAGE;
import static lotto.ErrorMessage.NUMBER_1_ESCAPE_ERROR_MESSAGE;
import static lotto.ErrorMessage.NUMBER_6_ESCAPE_ERROR_MESSAGE;
import static lotto.ErrorMessage.ONLY_INTEGER_ERROR_MESSAGE;
import static lotto.ErrorMessage.RANGE_1_45_ERROR_MESSAGE;
import static lotto.ErrorMessage.UNDER_1000_ERROR_MESSAGE;

import java.util.List;

public class Error {

    static final Error CHECK = new Error();

    private Error() {
    }

    public void isUnder1000Price(int price) {
        if (price < 1000) {
            UNDER_1000_ERROR_MESSAGE.print();
            throw new IllegalArgumentException(UNDER_1000_ERROR_MESSAGE.get());
        }
    }

    public void isAllInteger(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            ONLY_INTEGER_ERROR_MESSAGE.print();
            throw new IllegalArgumentException(ONLY_INTEGER_ERROR_MESSAGE.get());
        }
    }

    public void isRange45(int number) {
        if (number < 1 || number > 45) {
            RANGE_1_45_ERROR_MESSAGE.print();
            throw new IllegalArgumentException(RANGE_1_45_ERROR_MESSAGE.get());
        }
    }

    public void isDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            DUPLICATE_NUMBER_ERROR_MESSAGE.print();
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE.get());
        }
    }

    public void isCollect6Number(List<Integer> numbers) {
        if (numbers.size() != 6) {
            NUMBER_6_ESCAPE_ERROR_MESSAGE.print();
            throw new IllegalArgumentException(NUMBER_6_ESCAPE_ERROR_MESSAGE.get());
        }
    }

    public void isCollect1Number(List<Integer> numbers) {
        if (numbers.size() != 1) {
            NUMBER_1_ESCAPE_ERROR_MESSAGE.print();
            throw new IllegalArgumentException(NUMBER_1_ESCAPE_ERROR_MESSAGE.get());
        }
    }

}
