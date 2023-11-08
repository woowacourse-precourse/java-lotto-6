package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import lotto.config.LottoConfig;
import lotto.domain.Lotto;

public class LottoGenerate {
    public HashMap<Integer, Lotto> createLottoRepeat(int number) {
        HashMap<Integer, Lotto> allLotto = new HashMap<>();

        for (int i = 0; i < number; i++) {
            Lotto lotto = createLotto();
            allLotto.put(i, lotto);
        }

        return allLotto;
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoConfig.MIN_LOTTO_NUMBER,
                LottoConfig.MAX_LOTTO_NUMBER, LottoConfig.SIZE_OF_LOTTO);
        numbers = numbers.stream().sorted().toList();

        return new Lotto(numbers);
    }
}
