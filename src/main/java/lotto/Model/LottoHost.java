package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.ImageIcon;
import lotto.Controller.ErrorMessage;
import lotto.Model.VO.LottoData;

public class LottoHost {

    private Lotto answerLotto;
    private Integer bonusNumber;

    public void initAnswerLotto(List<Integer> numbers){
        answerLotto = new Lotto(numbers);
    }


    public void initBonusNumber(Integer number){
        validateLottoNumber(number);
        bonusNumber = number;
    }


    public Lotto generateLotto(){
        return new Lotto(generateRandomNumbers());
    }


    private List<Integer> generateRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }


    private void validateLottoNumber(Integer number){
        if(isNumberOutOfRange(number)){
            throw new IllegalArgumentException(ErrorMessage.BONUS_OUT_RANGE.getMessage());
        }
    }

    private boolean isNumberOutOfRange(Integer number){
        return number < 1  || 45 < number;
    }


    public LottoData getLottoData(){
            return answerLotto.getData();
    }

    public Integer getBonusNumberData(){
        return bonusNumber;
    }
}
