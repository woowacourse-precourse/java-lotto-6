package lotto;

import java.util.ArrayList;
import java.util.List;

public class CalculateLotto {

    private final List<Integer> answerNumbsers;

    public CalculateLotto(){
        answerNumbsers = new ArrayList<>();
    }

    public CalculateLotto(String numbers){
        answerNumbsers = new Lotto(numbers).getNumbers();
    }

    public int isCheckedLottoAnswer(Lotto lotto){
        int size = 0;

        for (Integer num : lotto.getNumbers()){
            if(answerNumbsers.contains(num)){
                size++;
            }
        }
        return size;
    }

    public boolean isCheckedBonusNumber(int bonusNumber){
        if(answerNumbsers.contains(bonusNumber)){
            return true;
        }
        return false;
    }
}
