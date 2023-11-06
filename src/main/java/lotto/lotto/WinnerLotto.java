package lotto.lotto;

import static lotto.constants.ErrorConstants.NOTINARRANGEERROR;

public class WinnerLotto {
    private Lotto lotto;
    private int bonusNum;


    public WinnerLotto(Lotto lotto, int bonusNum) {
        this.lotto = lotto;
        validate(bonusNum);
        this.bonusNum = bonusNum;
    }

    private void validate(int bonusNum){
        if (bonusNum < 1 || bonusNum > 45)
            throw new IllegalArgumentException(NOTINARRANGEERROR.toString());
    }
    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
