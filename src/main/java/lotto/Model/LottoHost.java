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
        validateLotto(numbers);
        answerLotto = new Lotto(numbers);
    }


    public void initBonusNumber(Integer number){
        validateLottoNumber(number);
        bonusNumber = number;
    }


    public void validateLotto(List<Integer> numbers){
        if(isNumbersOutOfRange(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 1~35 사이어야 합니다.");
        }
        if(isNumbersDuplicate(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 서로 다른 숫자여야 합니다.");
        }
    }


    public Lotto generateLotto(){
        return new Lotto(generateRandomNumbers());
    }


    private List<Integer> generateRandomNumbers(){
        List<Integer> host = new ArrayList<>();
        while (host.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!host.contains(randomNumber) && !isNumberOutOfRange(randomNumber)) {
                host.add(randomNumber);
            }
        }
        return host;
    }


    private void validateLottoNumber(Integer number){
        if(isNumberOutOfRange(number)){
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 1~35 사이어야 합니다.");
        }
    }

    private boolean isNumbersDuplicate(List<Integer> numbers){
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumbersOutOfRange(List<Integer> numbers){
        for(Integer number:numbers){
            if(isNumberOutOfRange(number))
                return true;
        }
        return false;
    }

    private boolean isNumberOutOfRange(Integer number){
        return number < 1  || 35 < number;
    }

    public LottoData getLottoData(){
            return answerLotto.getData();
    }

    public Integer getBonusNumberData(){
        return bonusNumber;
    }
}
