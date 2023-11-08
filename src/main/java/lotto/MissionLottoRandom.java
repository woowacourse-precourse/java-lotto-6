package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.LottoRandom;

public class MissionLottoRandom implements LottoRandom {
    private static int MIN = 1;
    private static int MAX = 45;
    private static int SIZE = 6;

    public List<Integer> generateNumbers() {
        List<Integer> numbers = List.copyOf(Randoms.pickUniqueNumbersInRange(MIN, MAX, SIZE));
        return numbers;
    }
}
