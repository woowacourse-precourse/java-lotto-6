package lotto.model;

import static lotto.util.Constant.LOTTO_MAX_RANGE;
import static lotto.util.Constant.LOTTO_MIN_RANGE;
import static lotto.util.Constant.LOTTO_NUMBERS_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private final List<List<Lotto>> lottoNumbers = new ArrayList<>();

    private static Lotto lottoNumberGenerate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE, LOTTO_NUMBERS_COUNT));
    }
}
