package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class LottoMaker {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;

    public static List<Lotto> makeLotto(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(index -> createNewLotto())
                .toList();
    }

    private static Lotto createNewLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                LOTTO_NUMBERS_SIZE);
        return new Lotto(numbers);
    }
}