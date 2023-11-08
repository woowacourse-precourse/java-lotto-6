package lotto.Input;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {
    public static Lotto createRandomLotto() throws IllegalArgumentException {
        List<Integer> input = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6);
        // input이 immutable한 List이므로 새로운 List 정의
        List<Integer> numbers = new ArrayList<>(input);
        numbers.sort(Comparator.naturalOrder());
        return new Lotto(numbers);
    }
}
