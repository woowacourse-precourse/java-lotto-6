package lotto;

import java.util.List;

public class BonusLotto {
    private final int bonusNum;

    public BonusLotto(int bonusNum) {
        validate(bonusNum);
        this.bonusNum = bonusNum;
    }

    private void validate(int bonusNum) {
        if (bonusNum<1 || bonusNum>45) {
            throw new IllegalArgumentException();
        }
    }
}
