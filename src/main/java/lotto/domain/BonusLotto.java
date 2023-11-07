package lotto.domain;

public class BonusLotto {
    private static int bonusNumber;
    public BonusLotto(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
}
