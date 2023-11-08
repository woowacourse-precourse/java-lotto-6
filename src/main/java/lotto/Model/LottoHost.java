package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.ImageIcon;
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
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 1~45 사이어야 합니다.");
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
