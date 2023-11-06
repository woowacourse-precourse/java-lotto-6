package lotto.domain;

public class PrizeLotto {
    private final Lotto lotto;
    private final int bonusNum;

    public PrizeLotto(Lotto lotto, int bonusNum){
        this.lotto = lotto;
        this.bonusNum = bonusNum;
    }

}
