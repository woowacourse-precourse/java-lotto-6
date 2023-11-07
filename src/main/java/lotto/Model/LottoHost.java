package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if(validateNumbersDuplicate(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 서로 다른 숫자여야 합니다.");
        }
    }

    private boolean validateNumbersDuplicate(List<Integer> numbers){
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) {
                return true;
            }
        }
        return false;
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
