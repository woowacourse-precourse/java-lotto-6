package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Value;

public class LottoSeller {
    private final int ZERO = Value.ZERO.get();
    private final int THOUSAND = Value.THOUSAND.get();

    public static LottoSeller create() {
        return new LottoSeller();
    }

    public LottoPaper sellLottos(int money) {
        int count = money / THOUSAND;
        LottoPaper lottoPaper = LottoPaper.create();
        for (int i = ZERO; i < count; i++) {
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