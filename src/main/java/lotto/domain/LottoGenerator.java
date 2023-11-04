package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoNumberConstants;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.constants.LottoNumberConstants.*;

public class LottoGenerator {
    public Lottos generateLottos(long quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }
        return Lottos.create(lottos);
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MINIMUM_RANGE, MAXIMUM_RANGE, NUMBERS_SIZE);
        numbers.sort(Comparator.naturalOrder());
        return new Lotto(numbers);
    }
}
