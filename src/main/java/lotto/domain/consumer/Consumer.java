package lotto.domain.consumer;


import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.common.Lotto;

import java.util.ArrayList;
import java.util.List;

public record Consumer(Price price, List<Lotto> consumerLottos, Count count) {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public Consumer {
        consumerLottos = new ArrayList<>();

        int value = price.value() / 1000;

        for (int i = 0; i < value; i++) {
            consumerLottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE)));
        }

        count = new Count(value);
    }

    public Consumer(Price price) {
        this(price, null, null);
    }
}

