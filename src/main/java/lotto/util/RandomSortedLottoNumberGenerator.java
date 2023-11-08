package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RandomSortedLottoNumberGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public static List<Integer> generateSortedLotto() {
        List<Integer> randomLottos = generateRandomNumber();

        return randomLottos.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER,LOTTO_SIZE);
    }
}