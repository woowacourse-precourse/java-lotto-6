package lotto.utils;

import static lotto.constants.LottoConstants.LOTTO_TOTAL_NUMBERS;
import static lotto.constants.LottoConstants.MAX_NUMBER;
import static lotto.constants.LottoConstants.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumberGenerator {
    Set<Integer> numbers = new HashSet<>();

    public List<Integer> generateNumbers() {
        while (numbers.size() < LOTTO_TOTAL_NUMBERS) {
            numbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
        return new ArrayList<>(numbers);
    }
}
