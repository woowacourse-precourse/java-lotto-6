package lotto;

import lotto.domain.IoLotto;

public class Application {
    public static void main(String[] args) {
        IoLotto ioLotto = new IoLotto();

        int money = ioLotto.inputMoney();
        Lotto purchasedLotto = (Lotto) ioLotto.purchaseLotto(money);

        ioLotto.checkResult(purchasedLotto, ioLotto.inputBonusNumber());
    }
}
