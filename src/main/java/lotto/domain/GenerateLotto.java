package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateLotto {
    private static final Integer LOTTO_SIZE = 6;
    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 45;

    public List<Lotto> lottoGroup(int ticketCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < ticketCount) {
            lottos.add(makeNumbers());
        }

        return lottos;
    }

    private Lotto makeNumbers() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_SIZE));
    }
}
