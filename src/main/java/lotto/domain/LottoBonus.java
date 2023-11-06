package lotto.domain;

import lotto.view.ExceptionMessage;

import java.util.List;

public class LottoBonus {
    private int number;

    public LottoBonus(Lotto lotto, int number){
        validate(lotto, number);
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }

    public void validate(Lotto lotto, int number){
        if(lotto.getNumbers().contains(number)){
            ExceptionMessage.duplicateException();
            throw new IllegalArgumentException();
        }
        if(number < 1 || number > 45){
            ExceptionMessage.rangeException();
            throw new IllegalArgumentException();
        }
    }
}
