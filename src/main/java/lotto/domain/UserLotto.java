package lotto.domain;

public class UserLotto {
    private Lotto lotto;
    private BonusLotto bonusLotto;
    public UserLotto(Lotto lotto, BonusLotto bonusLotto){
        this.lotto = lotto;
        this.bonusLotto = bonusLotto;
    }

    public Lotto getLotto(){
        return lotto;
    }

    public BonusLotto getBonusLotto(){
        return bonusLotto;
    }
}
