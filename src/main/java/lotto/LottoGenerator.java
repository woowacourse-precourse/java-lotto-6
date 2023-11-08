package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGenerator {

    private LottoGenerator() {}

    public static List<Integer> generate() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < Lotto.LOTTO_NUMBER_SIZE) {
            numbers.add(Randoms.pickNumberInRange(Lotto.LOTTO_NUMBER_MIN, Lotto.LOTTO_NUMBER_MAX));
        }
        return new ArrayList<>(numbers);
    }
}
