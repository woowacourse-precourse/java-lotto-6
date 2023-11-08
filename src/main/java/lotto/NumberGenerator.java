package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NumberGenerator {
    public List<Integer> generateRandomNumbers() {
        List<Integer> result = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return result;
    }
}
