package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Paper {
    private List<Integer> numbers;

    public void pickLottoNumber(){
        this.numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> getNumber(){
        return numbers;
    }

}
