package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.constants.LottoConstants.*;

public class LottoGenerator {
    public static Lottos generateLottos(long quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }
        return Lottos.create(lottos);
    }

    private static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MINIMUM_RANGE, MAXIMUM_RANGE, NUMBERS_SIZE);
        List<Integer> modifiableNumbers = new ArrayList<>(numbers);
        modifiableNumbers.sort(Comparator.naturalOrder());
        return new Lotto(modifiableNumbers);
    }
}
