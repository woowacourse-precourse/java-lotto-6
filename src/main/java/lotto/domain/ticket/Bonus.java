package lotto.domain.ticket;

import java.util.List;

public class Bonus {
    private int bonusNumber;

    public Bonus(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
    }
}
