package lotto.dto;

import static lotto.exception.ExceptionMessage.ILLEGAL_NUMBER;
import static lotto.exception.ExceptionMessage.NOT_DEVIDED_MONEY;

import net.bytebuddy.pool.TypePool.Resolution.Illegal;

public class MoneyRequest {
    private final int money;

    private MoneyRequest(int money) {
        validateDevidable(money);
        this.money = money;
    }

    public static MoneyRequest of(String input) {
        int money = stringToInt(input);
        return new MoneyRequest(money);
    }

    private static int stringToInt(String input) {
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e) { //그냥 엔터한 경우 null로 return되는데 이경우도 처리됨.
            throw new IllegalArgumentException(ILLEGAL_NUMBER.getMessage());
        }
    }

    private static void validateDevidable(int money) {
        if((money<=0) || (money % 1000) != 0) {
            throw new IllegalArgumentException(NOT_DEVIDED_MONEY.getMessage());
        }
    }

    public int getMoney() {
        return money;
    }
}
