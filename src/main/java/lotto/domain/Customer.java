package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int wallet;
    private List<Lotto> customerLotto;

    Customer(int coin) {
        validateCoin(coin);
        this.wallet = coin;
        this.customerLotto = new ArrayList<>();
    }

    private void validateCoin(int coin) {
        if (coin%1000!=0) {
            throw new IllegalArgumentException("구입금액은 1000단위만 허용합니다.");
        }
    }
}
