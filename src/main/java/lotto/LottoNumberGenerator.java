package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;

public class LottoNumberGenerator {

    public static List<Integer> run() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        while (validateDuplicate(numbers)) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }
        return numbers;
    }

    private static Boolean validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer num : numbers) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
