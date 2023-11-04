package lotto.model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.NumberConstant;

public class IssuedLotto {

    private final List<Integer> numbers;

    public IssuedLotto(){
        int min = NumberConstant.LOTTO_NUMBER_MIN;
        int max = NumberConstant.LOTTO_NUMBER_MAX;
        int count = NumberConstant.LOTTO_NUMBER_COUNT;
        numbers = Randoms.pickUniqueNumbersInRange(min,max,count);
    }

    public List<Integer> getSortedNumbers(){
        return numbers.stream().sorted().toList();
    }

}
