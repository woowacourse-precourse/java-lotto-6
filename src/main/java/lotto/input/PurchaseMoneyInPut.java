package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseMoneyInPut {
    static final String PURCHASE_MONEY = "구입 금액을 입력해 주세요.";
    static final String ERROR_PURCHASE_MONEY = "[ERROR] 1000원 단위로 입력 해야 합니다.";
    static final Integer MONEY_UNIT = 1000;
    static final Integer ZERO = 0;

    public static int purchaseMoney() {

        System.out.println(PURCHASE_MONEY);

        String money = Console.readLine();

        return Integer.parseInt(money);
    }

    public void purchaseMoneyValidator() {

        try {
            int money = purchaseMoney();

            if (money % MONEY_UNIT != ZERO) {
                throw new IllegalArgumentException(ERROR_PURCHASE_MONEY);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseMoneyValidator(); // 예외가 발생 하면 클래스 다시 실행
        }
    }
}
