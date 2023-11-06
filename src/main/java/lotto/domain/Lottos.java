package lotto.domain;

import static lotto.LottoRule.LOTTO_NUMBER_COUNT;
import static lotto.LottoRule.LOTTO_NUMBER_END;
import static lotto.LottoRule.LOTTO_NUMBER_START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(int size) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < size) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START.value(), LOTTO_NUMBER_END.value(),
                    LOTTO_NUMBER_COUNT.value())));
        }
        return new Lottos(lottos);
    }

}
