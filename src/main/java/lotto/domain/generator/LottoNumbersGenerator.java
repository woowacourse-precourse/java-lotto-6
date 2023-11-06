package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersGenerator {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int COUNT = 6;

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT)
                .stream().sorted().collect(Collectors.toList());
    }
}
