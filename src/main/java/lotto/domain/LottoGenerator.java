package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private List<Lotto> lottos = new ArrayList<>();
    final int LOTTO_COUNT;
    final int LOTTO_PRICE_UNIT = 1000;
    final int CHANGE = 0;

    public LottoGenerator(int payment) {
        LOTTO_COUNT = validatePayment(payment);
        for(int lotto = 0; lotto < LOTTO_COUNT; lotto++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            this.lottos.add(new Lotto(numbers));
        }
    }

    private int validatePayment(int payment) {
        if(payment < LOTTO_PRICE_UNIT) {
            throw new IllegalArgumentException("최소 결제 금액은 1,000원 입니다.");
        }
        if(payment % LOTTO_PRICE_UNIT != CHANGE) {
            throw new IllegalArgumentException("1,000원 단위로 결제해주세요.");
        }
        return payment/LOTTO_PRICE_UNIT;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
