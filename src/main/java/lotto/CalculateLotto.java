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

    public int isCheckedLottoAnswer(Lotto lotto,int bonusNumber){
        int size = 0;

        for (Integer num : lotto.getNumbers()){
            if(answerNumbsers.contains(num)){
                size++;
            }
        }
        if(size == 4){
            isCheckedBonusNumber(bonusNumber,lotto);
        }
        return size;
    }

    public boolean isCheckedBonusNumber(int bonusNumber,Lotto lotto){
        if(lotto.getNumbers().contains(bonusNumber)){
            return true;
        }
        return false;
    }
}
