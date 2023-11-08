package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConstant.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.LongStream;

public final class LottoGenerator {

    private LottoGenerator() {
    }

    public static Lotto autoGenerate() {
        List<Integer> randomNumbers = generateRandomNumbers();
        return new Lotto(randomNumbers);
    }

    public static List<Lotto> autoGenerateBy(long lottoCount) {
        return LongStream.rangeClosed(1, lottoCount)
                .mapToObj(c -> LottoGenerator.autoGenerate())
                .toList();
    }

    public static Lotto manualGenerate(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
    }

}
