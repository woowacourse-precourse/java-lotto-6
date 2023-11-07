package lotto.util;

import static lotto.constant.Constant.LOTTO_CNT;
import static lotto.constant.Constant.LOTTO_MAX_VALUE;
import static lotto.constant.Constant.LOTTO_MIN_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Lotto;

public class LottoRandomNumbersGenerator {

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE, LOTTO_CNT);
    }

    public static List<Lotto> generateLottoNumbers(int lottoPurchaseAmount) {
        return IntStream.range(0, lottoPurchaseAmount)
                .mapToObj(i -> Lotto.issueLotto(generate()))
                .collect(Collectors.toList());
    }
}
