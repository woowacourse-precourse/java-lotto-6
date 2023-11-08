package lotto.common;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    public static List<Integer> generateLottoNumber(){
        List<Integer> numbers_copy = new ArrayList<>();
        List<Integer> numbers = Randoms
                .pickUniqueNumbersInRange(Constant.LOTTO_MIN, Constant.LOTTO_MAX, Constant.LOTTO_SIZE);

        for(int n : numbers) numbers_copy.add(n);
        Collections.sort(numbers_copy);
        return numbers_copy;
    }
}
