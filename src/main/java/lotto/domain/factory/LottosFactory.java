package lotto.domain.factory;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.exception.ExceptionMessage;

public class LottosFactory {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int TEN_THOUSAND = 1000;

    public Lottos createLottos(int money) {
        List<Lotto> lottos = new ArrayList<>();
        validateTenThousandMultiple(money);
        int amount = toAmount(money);

        for (int i = 0; i < amount; i++) {
            lottos.add(createLotto());
        }

        return new Lottos(lottos);
    }

    private void validateTenThousandMultiple(int money) {
        if (money == 0 || money % TEN_THOUSAND != 0) {
            throw new IllegalArgumentException(ExceptionMessage.MONEY_TEN_THOUSAND_UNIT_EXCEPTION.getMessage());
        }
    }

    private int toAmount(int money) {
        return money / TEN_THOUSAND;
    }

    private Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_SIZE));
    }
}
