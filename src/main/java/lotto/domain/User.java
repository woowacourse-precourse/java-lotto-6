package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Lottos> lottoNumbers;
    private int money;

    public User(String money) {
        lottoNumbers = new ArrayList<>();
        this.money = changeInteger(money);
    }

    public List<Lottos> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getMoney() {
        return money;
    }

    private int changeInteger(String money) {
        return Integer.parseInt(money);
    }

    public void storePurchasedLotto(Lottos lottos) {
        lottoNumbers.add(lottos);
    }
}
