package lotto.domain;

import java.util.List;

public class Bonus {
    int bonusNumber;

    public Bonus(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(bonusNumber);
    }
}
