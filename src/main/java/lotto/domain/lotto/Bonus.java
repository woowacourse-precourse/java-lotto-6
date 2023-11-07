package lotto.domain.lotto;

public class Bonus{

    private final int bonusNumber;

    public Bonus(int bonusNumber){
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber){
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

}
