package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class RandomLottoGenerator {

    private static final int MIN_NUMBER = Number.MIN_VALUE;
    private static final int MAX_NUMBER = Number.MAX_VALUE;
    private static final int SIZE = Lotto.NUMBER_SIZE;

    private RandomLottoGenerator() {
    }

    public static List<Lotto> generate(int size) {
        validate(size);
        return IntStream.range(0, size)
                .mapToObj(index -> RandomLottoGenerator.generate())
                .toList();
    }

    private static void validate(int size) {
        if (isNegativeOrZero(size)) {
            throw new IllegalArgumentException("로또의 개수는 양수이어야 합니다");
        }
    }

    private static boolean isNegativeOrZero(int number) {
        return number <= 0;
    }

    private static Lotto generate() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MAX_NUMBER, MIN_NUMBER, SIZE);
        return new Lotto(randomNumbers);
    }
}
