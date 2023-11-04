package lotto.domain;

import java.util.List;

public class User {

    public Integer lottoCount;
    public List<Lotto> lottos;
    Money money;


    public void payMoney() {
        money = new Money(Computer.getInput());
    }

    public void purchaseLotto() {
        boolean isPurchasing = true;
        while (isPurchasing) {
            try {

                payMoney();
                lottoCount = money.countThousand();

                isPurchasing = false;

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());   // 분리?
            }
        }
    }


}
