package lotto.service;

import static lotto.utils.IntegerConstant.ZERO;
import static lotto.utils.LottoConstant.LOTTO_END_NUMBER;
import static lotto.utils.LottoConstant.LOTTO_NUMBERS_SIZE;
import static lotto.utils.LottoConstant.LOTTO_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.lotto.Lotto;

public class LottoGenerator {

    private final int lottoSize;

    public static LottoGenerator of(int lottoSize) {
        return new LottoGenerator(lottoSize);
    }

    private LottoGenerator(int lottoSize) {
        this.lottoSize = lottoSize;
    }

    public List<Lotto> generate() {
        return IntStream.range(ZERO, this.lottoSize)
                .mapToObj(count -> generateSingleLotto())
                .toList();
    }

    private Lotto generateSingleLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER,
                        LOTTO_END_NUMBER,
                        LOTTO_NUMBERS_SIZE)
                .stream()
                .sorted()
                .toList();

        return Lotto.of(numbers);
    }
}
