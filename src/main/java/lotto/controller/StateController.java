package lotto.controller;

import lotto.view.InputView;


public class StateController {

    private static final int LOTTO_PRICE = 1000;

    private int money;

    public void purchaseLotto() {
        int money = Integer.parseInt(InputView.readMoney());
        try {
            validateMoney(money);
            this.money = money;
        }catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            purchaseLotto();
        }
    }

    private void validateMoney(int money) {
        if (money == 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000 원 이상이여야 합니다.");
        }
        if ((money % LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000 원 단위로 입력해주셔야 합니다.");
        }
    }
}
