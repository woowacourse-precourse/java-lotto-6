package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumbersGenerator implements NumbersGenerator {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE,
                LOTTO_NUMBER_COUNT);
    }
}
