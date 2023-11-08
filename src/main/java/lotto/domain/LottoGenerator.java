package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.NumberConstants.*;

public class LottoGenerator {
    private final List<Lotto> lottos;

    public LottoGenerator(long ticketNumber) {
        this.lottos = generateLottos(ticketNumber);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private List<Lotto> generateLottos(long ticketNumber) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() != ticketNumber) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE));
    }
}
