package lotto.domain;

import java.util.List;

public class LottoValidator {
    private Lotto myNumber;
    private Lotto winNumber;
    private int bonusNumber;

    public LottoValidator(Lotto myNumber, Lotto winNumber, int bonusNumber){
        this.myNumber = myNumber;
        this.winNumber = winNumber;
        this.bonusNumber = bonusNumber;
    }

    public int compareNumber(){
        int correctNumber = 0;
        for (int i = 0; i < myNumber.length() ; i++) {
            if (winNumber.contains(myNumber.get(i))){
                correctNumber ++;
            }
        }
        return correctNumber;
    }

    public Boolean isBonus(){
        return myNumber.contains(bonusNumber);
    }


}
