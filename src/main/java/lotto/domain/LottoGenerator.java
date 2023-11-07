package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private List<Lotto> lottos = new ArrayList<>();
    private final int lottoCount;
    private static final int LOTTO_PRICE_UNIT = 1000;
    private static final int CHANGE = 0;
    private static final int ZERO_COUNT = 0;
    private static final int MINIMUM_RANGE = 1;
    private static final int MAXIMUM_RANGE = 45;
    private static final int NUMBER_PICK_COUNT = 6;

    public LottoGenerator(int payment) {
        this.lottoCount = validatePayment(payment);
        for (int lotto = ZERO_COUNT; lotto < lottoCount; lotto++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MINIMUM_RANGE, MAXIMUM_RANGE, NUMBER_PICK_COUNT);
            this.lottos.add(new Lotto(numbers));
        }
    }

    private int validatePayment(int payment) {
        if (payment < LOTTO_PRICE_UNIT) {
            throw new IllegalArgumentException("[Error] 최소 결제 금액은 1,000원 입니다.");
        }
        if (payment % LOTTO_PRICE_UNIT != CHANGE) {
            throw new IllegalArgumentException("[Error] 1,000원 단위로 결제해주세요.");
        }
        return payment / LOTTO_PRICE_UNIT;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
