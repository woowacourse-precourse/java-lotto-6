package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.NumberStrategy;

public class LottoMachine {
    public static List<Lotto> publish(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(getAutoNumbers()));
        }

        return lottos;
    }

    private static List<Integer> getAutoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                NumberStrategy.MIN_NUMBER.getNumber(),
                NumberStrategy.MAX_NUMBER.getNumber(),
                NumberStrategy.LOTTO_NUMBER_COUNT.getNumber()
        );
    }
}
