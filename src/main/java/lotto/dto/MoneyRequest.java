package lotto.dto;

import static lotto.exception.ExceptionMessage.ILLEGAL_NUMBER;
import static lotto.exception.ExceptionMessage.NOT_DEVIDED_MONEY;

import lotto.controller.LottoController;
import lotto.view.InputView;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;

public class MoneyRequest {
    private final int money;

    public MoneyRequest (String input) {
        int money = stringToInt(input);
        validateNotDevidedMoney(money);
        this.money = money;
    }

    private static int stringToInt(String input) {
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e) { //그냥 엔터한 경우 null로 return되는데 이경우도 처리됨.
            System.out.println(ILLEGAL_NUMBER.getMessage());
            return stringToInt(InputView.readMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(ILLEGAL_NUMBER.getMessage());
            return stringToInt(InputView.readMoney());
        }
    }

    private static void validateNotDevidedMoney(int money) {
        if((money <= 0) || (money % 1000 != 0)){
            System.out.println(NOT_DEVIDED_MONEY.getMessage());
            throw new IllegalArgumentException(NOT_DEVIDED_MONEY.getMessage());
        }
    }

    public int getMoney() {
        return money;
    }
}
