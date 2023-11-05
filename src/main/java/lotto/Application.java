package lotto;

import lotto.domain.BuyLotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BuyLotto buyLotto = new BuyLotto();
        int LottoAmount = buyLotto.inputMoney();
        System.out.println(LottoAmount);
    }
}
