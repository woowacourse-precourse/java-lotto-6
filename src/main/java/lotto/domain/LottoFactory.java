package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum LottoFactory {
    INSTANCE;

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    public static List<Lotto> createLottos(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> createLotto())
                .collect(Collectors.toList());
    }

    private static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBERS_COUNT);
        return new Lotto(numbers);
    }
}
