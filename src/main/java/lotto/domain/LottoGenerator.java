package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Stream;

import static lotto.utils.Constants.*;

public class LottoGenerator {

    public static List<Lotto> createLottos(int size) {
        return Stream.generate(LottoGenerator::createLotto)
                .limit(size)
                .toList();
    }

    private static Lotto createLotto() {
        return new Lotto(pickUniqueNumbers());
    }

    private static List<Integer> pickUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_NUMBERS_SIZE);
    }
}
