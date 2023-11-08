package lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomSortedLottoNumberGenerator {
    private static final int LOTTO_SIZE = 6;

    public static List<Integer> generateSortedLotto() {
        List<Integer> randomLottos = RandomUniqueNumbersGenerator.generateRandomNumber();
        randomLottos.stream().sorted();
        return randomLottos;
    }
}