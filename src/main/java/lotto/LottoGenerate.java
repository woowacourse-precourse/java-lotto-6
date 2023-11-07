package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Config.MIN_LOTTO_NUMBER,
                Config.MAX_LOTTO_NUMBER, Config.SIZE_OF_LOTTO);
        Collections.sort(numbers);

        return new Lotto(numbers);
    }
}
