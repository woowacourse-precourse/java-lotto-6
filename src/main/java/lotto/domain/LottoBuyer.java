package lotto.domain;

import lotto.Validator;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyer {

    private List<Lotto> lottos;
    private int money;
    private int purchaseNumber;

    public LottoBuyer(String money) {
        this.lottos = new ArrayList<>();
        this.money = Validator.validateMoney(money);
        this.purchaseNumber = this.money / 1000;
    }

    public void buyLotto() {
        for (int i = 0; i < purchaseNumber; i++) {

        }
    }
}
