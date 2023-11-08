package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Value;
import java.math.BigDecimal;

public class LottoSeller {
    private final int ZERO = Value.ZERO.get();
    private final int THOUSAND = Value.THOUSAND.get();

    public static LottoSeller create() {
        return new LottoSeller();
    }

    public LottoPaper sellLottos(BigDecimal money) {
        BigDecimal count = money.divide(BigDecimal.valueOf(THOUSAND));
        LottoPaper lottoPaper = LottoPaper.create();
        for (long i = ZERO; i < count.longValue(); i++) {
            lottoPaper.add(issueLotto());
        }
        return lottoPaper;
    }

    private Lotto issueLotto() {
        int start = Value.START_NUMBER.get();
        int end = Value.END_NUMBER.get();
        int count = Value.LOTTO_NUMBER_COUNT.get();
        return Lotto.from(Randoms.pickUniqueNumbersInRange(start, end, count));
    }
}