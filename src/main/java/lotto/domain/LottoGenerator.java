package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static List<Integer> getLottoNumbers() {
        List<Integer> numbers = pickLottoNumbers();
        Collections.sort(numbers);
        return numbers;
    }
    private static List<Integer> pickLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; ++i) {
            int number = pickNumber();
            if (numbers.contains(number)) {
                i--;
                continue;
            }
            numbers.add(number);
        }
        return numbers;
    }
    private static int pickNumber() {
        return Randoms.pickNumberInRange(1, 46);
    }
}
