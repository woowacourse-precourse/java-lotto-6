package lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomSortedLottoNumberGenerator {
    private static final int LOTTO_SIZE = 6;

    public static List<Integer> generateSortedLotto() {
        List<Integer> randomLotto = generateRandomLotto();
        return randomLotto;
    }

    private static List<Integer> generateRandomLotto() {
        return IntStream.generate(RandomNumberGenerator::generateRandomNumber)
                .distinct()
                .limit(LOTTO_SIZE)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }

}