package lotto.Exception;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoIntegerException {

    public int checkForPriceException(String initialPrice) {
        int price = checkInt(initialPrice);

        if (price < 0) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }

        return price;
    }

    public int checkForBonus(String initialBonus) {
        int bonus = checkInt(initialBonus);
        checkPositive(bonus);

        return bonus;
    }

    public int checkInt(String initialNumber) {
        try {
            int number = Integer.parseInt(initialNumber);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }

    public void checkPositive(int number) {
        if (number < 1 && number > 45) {
            throw new IllegalArgumentException("1부터 45까지의 숫자를 입력해주세요.");
        }
    }

}
