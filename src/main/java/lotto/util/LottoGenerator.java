package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator implements NumberGenerator {


    private static LottoGenerator instance;

    private LottoGenerator() {
    }


    public static LottoGenerator getInstance() {
        if (instance == null) {
            return new LottoGenerator();
        }
        return instance;
    }

    @Override
    public List<Integer> generateNumberList() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers.stream().sorted().toList();
    }
}
