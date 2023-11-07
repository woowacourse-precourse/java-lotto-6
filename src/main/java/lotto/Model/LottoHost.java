package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoHost {

    private Lotto AnswerLotto;
    private Integer bonusNumber;

    public void initAnswerLotto(List<Integer> numbers){
        validateLotto(numbers);
    }

    public void validateLotto(List<Integer> numbers){
        if(validateNumbersInRange(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 1~35 사이어야 합니다.");
        }
    }

    private boolean validateNumbersInRange(List<Integer> numbers){
        for(Integer number:numbers){
            if(isNumberOutRange(number))
                return true;
        }
        return false;
    }

    private boolean isNumberOutRange(Integer number){
        return number < 1  || 35 < number;
    }
    public Lotto generateLotto(){
        return new Lotto(generateRandomNumbers());
    }


    private List<Integer> generateRandomNumbers(){
        List<Integer> host = new ArrayList<>();
        while (host.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!host.contains(randomNumber)) {
                host.add(randomNumber);
            }
        }
        return host;
    }
}
