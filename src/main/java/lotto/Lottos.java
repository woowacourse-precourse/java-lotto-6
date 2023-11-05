package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Lottos {
    private final List<Lotto> lottos;

    Lottos(int quantity) {
        lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(randomNumbers()));
        }
    }

    private List<Integer> randomNumbers() {
        List<Integer> numbers = pickUniqueNumbersInRange(
                LottoConstants.LOTTO_START_NUMBER.getConstant(),
                LottoConstants.LOTTO_END_NUMBER.getConstant(),
                LottoConstants.LOTTO_PER_NUMBERS.getConstant()
        );
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
