package lotto.model;

import lotto.constants.Constants;
import lotto.constants.Message;

public class Validator {
    public void validateCost(String cost, Integer lottoPrice) {
        if (notNumeric(cost)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
        if (notThousands(cost, lottoPrice)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000의 배수여야 합니다.");
        }
    }

    private boolean notThousands(String cost, Integer lottoPrice) {
        return (Integer.parseInt(cost) % lottoPrice != 0);
    }

    public void validateAnswer(String number, Integer start, Integer end) {
        if (notNumeric(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
        if (outOfRange(number, start, end)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void validateBonus(String number, Integer start, Integer end) {
        if (notNumeric(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
        if (outOfRange(number, start, end)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean notNumeric(String number) {
        return !number.matches(Message.REGULAR_NUMBER);
    }

    private boolean outOfRange(String number, Integer start, Integer end) {
        Integer num = Integer.parseInt(number);

        return (num < start || end < num);
    }
}
