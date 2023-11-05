package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoRandom {
    private static int MIN = 1;
    private static int MAX = 45;
    private static int SIZE = 6;

    public List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            numbers.add(Randoms.pickNumberInRange(MIN, MAX));
        }
        return numbers;
    }

}
