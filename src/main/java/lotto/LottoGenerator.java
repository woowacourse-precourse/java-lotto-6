package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.GameConfig.*;

public class LottoGenerator {
    public static List<Lotto> generateLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();

        while (numberOfLottos != lottos.size()) {
            lottos.add(new Lotto(generateRandomLotto()));
        }
        return lottos;
    }

    private static List<Integer> generateRandomLotto() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_LOWER_BOUND,
                LOTTO_NUMBER_UPPER_BOUND,
                NUMBER_OF_LOTTO_NUMBERS
        );
    }
}
