package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public Lotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isContainsNumber(int userNumber){
        if(numbers.contains(userNumber)) {
            return true;
        }

        return false;
    }

    public boolean isContainsBonusNumber(List<Integer> userNumbers){
        if(userNumbers.contains(this.bonusNumber)){
            return true;
        }
        return false;
    }

}
