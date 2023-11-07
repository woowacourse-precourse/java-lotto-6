package lotto.domain;

import java.util.List;

public class UserLotto {
    private final List<Integer> lottoNumber;
    private final int bonusNumber;
    private final int money;

    public UserLotto(List<Integer> lottoNumber, int bonusNumber, int money) {
        this.lottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
        this.money = money;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getMoney() {
        return money;
    }
}
