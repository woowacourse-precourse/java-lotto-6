package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class LottoNumberGenerator {
    public List<Integer> generateNumbers() {
        List<Integer> numbers;
        do {
            numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        } while (hasDuplicates(numbers));
        Collections.sort(numbers);
        return Collections.unmodifiableList(numbers);
    }

    private static boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int num : numbers) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
