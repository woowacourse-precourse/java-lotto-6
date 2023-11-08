package view;

import camp.nextstep.edu.missionutils.Console;
import domain.ErrorCode;

public class MoneyInput {

    private final int LOTTO_PRICE = 1000;
    private final String MONEY_WORD = "구입금액을 입력해 주세요.";

    private int money;

    public void moneyInput() {
        System.out.println(MONEY_WORD);
        String money = Console.readLine();
        validationMoney(money);
    }

    private void validationMoney(String money) {
        try {
            this.money = Integer.parseInt(money);
            if (this.money % LOTTO_PRICE > 0) {
                throw new IllegalArgumentException(ErrorCode.MONEY_NOT_DIVIDE.getErrorMessage());
            }
        } catch (NumberFormatException e) {
            System.out.println(ErrorCode.MONEY_NOT_INTEGER.getErrorMessage());
            moneyInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            moneyInput();
        }
    }

    public int getMoney() {
        return money;
    }
}
