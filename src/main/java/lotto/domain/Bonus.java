package lotto.domain;

public class Bonus{

    private final int bonusNumber;

    public Bonus(int bonusNumber){
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber){
    }

}
