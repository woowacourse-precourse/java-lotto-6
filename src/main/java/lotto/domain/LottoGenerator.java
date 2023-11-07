package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.util.IllegalArgumentMessage;
import lotto.util.LottoConstant;

public class LottoGenerator {
    private List<Lotto> lottos = new ArrayList<>();
    private final int maxGeneratingCount;
    private static final int CHANGE = 0;

    public LottoGenerator(int payment) {
        validatePayment(payment);
        this.maxGeneratingCount = payment / LottoConstant.PRICE_UNIT;
        for (int lotto = 0; lotto < maxGeneratingCount; lotto++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LottoConstant.MINIMUM_RANGE,
                    LottoConstant.MAXIMUM_RANGE,
                    LottoConstant.PICK_COUNT
            );
            this.lottos.add(new Lotto(numbers));
        }
    }

    private void validatePayment(int payment) {
        if (payment < LottoConstant.PRICE_UNIT) {
            throw new IllegalArgumentException(IllegalArgumentMessage.ERROR_LESS_THAN_MINIMUM_PRICE);
        }
        if (payment % LottoConstant.PRICE_UNIT != CHANGE) {
            throw new IllegalArgumentException(IllegalArgumentMessage.ERROR_NOT_PRICE_UNIT);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
