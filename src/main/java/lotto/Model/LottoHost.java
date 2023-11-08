package lotto.Model;

import java.util.List;
import lotto.Controller.ErrorMessage;

public class LottoHost {

    private Lotto answerLotto;
    private Integer bonusNumber;

    public void initAnswerLotto(List<Integer> numbers){
        answerLotto = new Lotto(numbers);
    }


    public void initBonusNumber(Integer number){
        validateBonusNumber(number);
        bonusNumber = number;
    }


    public Lotto generateLotto(){
        return new Lotto(LottoUtil.generateRandomNumbers());
    }

    private void validateBonusNumber(Integer number){
        if(LottoUtil.isNumberOutOfRange(number)){
            throw new IllegalArgumentException(ErrorMessage.BONUS_OUT_RANGE.getMessage());
        }
    }


    public LottoData getLottoData(){
            return answerLotto.getData();
    }

    public Integer getBonusNumberData(){
        return bonusNumber;
    }
}
