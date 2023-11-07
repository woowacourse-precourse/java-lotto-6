package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateLottoNumber {
    private List<Integer> numbers;

    public List<Integer> selectNumber(){
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> numberSorted = new ArrayList<>(numbers);
        Collections.sort(numberSorted);
        return numbers;
    }

}
