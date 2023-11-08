package lotto.common;

import static lotto.common.util.LottoUtil.DUPLICATE;
import static lotto.common.util.LottoUtil.MAX;
import static lotto.common.util.LottoUtil.MIN;
import static lotto.common.util.LottoUtil.SIZE;
import static lotto.common.util.LottoUtil.THOUSAND;
import static lotto.common.util.LottoUtil.ZERO;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Validation {

    private static final String ONLY_NUMBER_CHECK = "[-+]?\\d*\\.?\\d+";

    public static void lottoSize(List<Integer> numbers) {
        if (numbers.size() != SIZE.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    public static void lottoDuplicate(List<Integer> numbers) {
        List<Integer> duplicates = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > DUPLICATE.getNumber())
                .map(Map.Entry::getKey)
                .toList();

        if (!duplicates.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void lottoLimit(List<Integer> numbers) {
        List<Integer> outOfRangeNumbers = numbers.stream()
                .filter(number -> number < MIN.getNumber() || number > MAX.getNumber())
                .toList();

        if (!outOfRangeNumbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static Integer lottoDuplicateBonusNumber(String lotto, String bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(bonus);
    }

    public static void blankCheck(String strLotto) {
        if (strLotto.isEmpty() || strLotto.equals(",")) {
            throw new IllegalArgumentException();
        }
    }

    public static void lottoPriceCheck(Integer buyPrice) {
        if (buyPrice % THOUSAND.getNumber() != ZERO.getNumber()) {
            throw new IllegalArgumentException();
        }
    }

    public static void onlyNumberCheck(String inputData) {
        if (!(inputData != null && inputData.matches(ONLY_NUMBER_CHECK))) {
            throw new IllegalArgumentException();
        }
    }
}
