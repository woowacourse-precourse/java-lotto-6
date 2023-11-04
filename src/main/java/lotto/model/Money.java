package lotto.model;

import lotto.exception.NonPositiveAmountException;
import lotto.exception.InvalidAmountFormatException;

public class Money {

    private final int money;

    public Money(String money) {
        int convertMoney = parseInt(money);
        this.money = validateMinus(convertMoney);
    }

    /**
     * 문자열을 정수로 변환한다.
     *
     * @param money 가격을 숫자로 변환한다.
     * @return int로 변환된 정수를 반환한다.
     */
    private int parseInt(String money) {
        try {
            return Integer.parseInt(money);
        } catch (Exception e) {
            throw new InvalidAmountFormatException();
        }
    }

    /**
     * 입력한 값이 음수인지 검증
     *
     * @param money
     * @return
     */
    private int validateMinus(int money) {
        if (money <= 0) {
            throw new NonPositiveAmountException();
        }

        return money;
    }

    public int getMoney() {
        return money;
    }
}
