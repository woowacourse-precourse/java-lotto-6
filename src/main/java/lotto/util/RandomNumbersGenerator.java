package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public static List<Integer> generateSortedLotto() {
        List<Integer> randomLotto = generateRandomLotto();
        sortLotto(randomLotto);
        return randomLotto;
    }

    private static List<Integer> generateRandomLotto() {
        return IntStream.generate(() -> generateRandomNumber())
                .distinct()
                .limit(LOTTO_SIZE)
                .boxed()
                .collect(Collectors.toList());
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    private static void sortLotto(List<Integer> lotto) {
        Collections.sort(lotto);
    }
}