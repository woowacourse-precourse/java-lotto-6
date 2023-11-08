package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static lotto.constant.ConstantNumber.*;

public class LottoNumberGenerator {

    public List<Integer> generateLotto() {
        Set<Integer> numbers = new HashSet<>();
        while(numbers.size() < LOTTO_SIZE) {
            numbers.add(generateNumber());
        }
        return new ArrayList<>(numbers);
    }

    private int generateNumber() {
        return Randoms.pickNumberInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM);
    }
}

