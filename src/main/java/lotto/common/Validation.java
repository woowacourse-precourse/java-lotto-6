package lotto.common;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.common.util.LottoUtil;

public final class Validation {

    public static void lottoSize(List<Integer> numbers) {
        if (numbers.size() != LottoUtil.SIZE.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    public static void lottoDuplicate(List<Integer> numbers) {
        List<Integer> duplicates = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > LottoUtil.DUPLICATE.getNumber())
                .map(Map.Entry::getKey)
                .toList();

        if (!duplicates.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void lottoLimit(List<Integer> numbers) {
        List<Integer> outOfRangeNumbers = numbers.stream()
                .filter(number -> number < LottoUtil.MIN.getNumber() || number > LottoUtil.MAX.getNumber())
                .toList();

        if (!outOfRangeNumbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
