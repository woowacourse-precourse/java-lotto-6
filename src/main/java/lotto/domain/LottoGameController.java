package lotto.domain;

import lotto.global.view.InputView;

public class LottoGameController {

    public void run() {
        Money money = generateMoney();
    }

    private Money generateMoney() {
        while (true) {
            try {
                int purchaseMoney = InputView.getPurchaseMoney();
                return new Money(purchaseMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
