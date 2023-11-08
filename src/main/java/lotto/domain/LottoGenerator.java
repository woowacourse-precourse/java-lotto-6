package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.Numbers.*;

public class LottoGenerator {
    private final List<Lotto> lottos;

    public LottoGenerator(int ticketNumber) {
        this.lottos = generateLottos(ticketNumber);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private List<Lotto> generateLottos(int ticketNumber) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() != ticketNumber) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
