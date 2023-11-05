package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private static final int ZERO = 0;
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_COUNT = 6;

    public static List<Lotto> generateLottoNumbers(int purchaseAmount) {
        int lottoAmount = purchaseAmount / PURCHASE_AMOUNT_UNIT;

        return IntStream.range(ZERO, lottoAmount)
                .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_COUNT)))
                .collect(Collectors.toList());
    }
}