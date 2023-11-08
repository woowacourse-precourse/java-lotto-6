package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Stream;

import static lotto.utils.Constants.*;

public class LottoGenerator {
    private static LottoGenerator instance = null;

    private LottoGenerator() {
    }

    public static LottoGenerator getInstance() {
        if (instance == null) {
            instance = new LottoGenerator();
        }
        return instance;
    }

    public List<Lotto> createLottos(int size) {
        return Stream.generate(this::createLotto)
                .limit(size)
                .toList();
    }

    private Lotto createLotto() {
        return new Lotto(pickUniqueNumbers());
    }

    private List<Integer> pickUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_NUMBERS_SIZE);
    }
}
