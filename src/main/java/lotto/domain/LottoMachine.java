package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    enum NumberStrategy {
        MAX_NUMBER(45),
        MIN_NUMBER(1),
        LOTTO_NUMBER_COUNT(6);

        private final int number;

        NumberStrategy(int i) {
            this.number = i;
        }

        public int getNumber() {
            return number;
        }
    }

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
