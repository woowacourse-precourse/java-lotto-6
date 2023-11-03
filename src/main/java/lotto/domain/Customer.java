package lotto.domain;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int wallet;
    private List<Lotto> customerLotto;

    public Customer(int coin) {
        validateCoin(coin);
        this.wallet = coin;
        this.customerLotto = new ArrayList<>();
    }

    private void validateCoin(int coin) {
        if (coin%1000!=0) {
            throw new IllegalArgumentException("구입금액은 1000단위만 허용합니다.");
        }
    }
    public int getWallet() {
        return this.wallet;
    }
    public List<Lotto> getCustomerLotto() {
        return this.customerLotto;
    }
    public void setCustomerLotto(List<Lotto> newLotto) {
        this.customerLotto = newLotto;
    }
}
