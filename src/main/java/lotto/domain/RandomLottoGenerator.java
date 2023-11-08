package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class RandomLottoGenerator {

    private static final int MIN_NUMBER = Number.MIN_VALUE;
    private static final int MAX_NUMBER = Number.MAX_VALUE;
    private static final int COUNT_OF_NUMBER = Lotto.NUMBER_SIZE;

    private RandomLottoGenerator() {
    }

    public static List<Lotto> generate(int size) {
        validate(size);
        return generateRandomLottos(size);
    }

    private static void validate(int size) {
        if (isNegativeOrZero(size)) {
            throw new IllegalArgumentException("로또의 개수는 양수이어야 합니다");
        }
    }

    private static boolean isNegativeOrZero(int number) {
        return number <= 0;
    }

    private static List<Lotto> generateRandomLottos(int size) {
        return IntStream.range(0, size)
                .mapToObj(index -> RandomLottoGenerator.generateRandomLotto())
                .toList();
    }

    private static Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT_OF_NUMBER);
        return new Lotto(randomNumbers);
    }
}
