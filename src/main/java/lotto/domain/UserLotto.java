package lotto.domain;

import java.util.List;

public class UserLotto {
    private final Lotto numbers;
    private final int bonusNum;
    private final int amount;

    public UserLotto(Lotto numbers, int bonusNum, int amount) {
        this.numbers = numbers;
        this.bonusNum = bonusNum;
        this.amount = amount;
    }
}
