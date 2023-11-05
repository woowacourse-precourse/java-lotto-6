package lotto.domain;

import java.util.List;
import lotto.ui.Input;
import lotto.ui.Output;

public class User {

    public Integer lottoCount;
    public List<Lotto> lottos;
    Money money;

    public void payMoney() {
        money = new Money(Input.get());
    }

    public void purchaseLotto() {
        boolean isPurchasing = true;

        while (isPurchasing) {
            try {
                payMoney();
                lottoCount = money.countThousand();
                lottos = LottoGenerator.createLottos(lottoCount);
                isPurchasing = false;
            } catch (IllegalArgumentException ex) {
                Output.printError(ex);
            }
        }
    }


}
