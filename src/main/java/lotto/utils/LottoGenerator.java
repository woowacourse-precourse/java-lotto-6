package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;

    public static List<Lotto> generateLottos(int number) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < number; count++) {
            lottos.add(new Lotto(generateLotto()));
        }
        return lottos;
    }

    public static List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_SIZE);
    }

}
