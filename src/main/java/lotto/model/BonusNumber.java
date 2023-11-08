package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class BonusNumber {
    private int number;
    public BonusNumber(List<Integer> answerLotto, int number){
        validate(answerLotto,number);
        this.number=number;
    }
    private void validate(List<Integer> answerLotto, int number){
        if (answerLotto.contains(number)){
            throw new IllegalArgumentException();
        }
    }
}
