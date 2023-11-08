package lotto.common;

import static lotto.common.util.ErrorMessage.BLANK;
import static lotto.common.util.ErrorMessage.DUPLICATE_BONUS;
import static lotto.common.util.ErrorMessage.LIMIT;
import static lotto.common.util.ErrorMessage.ONLY_NUMBER;
import static lotto.common.util.ErrorMessage.PRICE_CHECK;
import static lotto.common.util.LottoUtil.DUPLICATE;
import static lotto.common.util.LottoUtil.MAX;
import static lotto.common.util.LottoUtil.MIN;
import static lotto.common.util.LottoUtil.SIZE;
import static lotto.common.util.LottoUtil.THOUSAND;
import static lotto.common.util.LottoUtil.ZERO;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.common.util.ErrorMessage;

public final class Validation {

    private static final String ONLY_NUMBER_CHECK = "[-+]?\\d*\\.?\\d+";

    public static void lottoSize(List<Integer> numbers) {
        if (numbers.size() != SIZE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.SIZE.getMessage());
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
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE.getMessage());
        }
    }

    public static void lottoLimit(List<Integer> numbers) {
        List<Integer> outOfRangeNumbers = numbers.stream()
                .filter(number -> number < MIN.getNumber() || number > MAX.getNumber())
                .toList();

        if (!outOfRangeNumbers.isEmpty()) {
            throw new IllegalArgumentException(LIMIT.getMessage());
        }
    }

    public static Integer lottoDuplicateBonusNumber(String lotto, String bonus) {
        List<Integer> lottoList = Arrays.stream(lotto.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();

        int bonusNumber = Integer.parseInt(bonus.trim());

        boolean hasExactMatch = lottoList.stream()
                .anyMatch(number -> number == bonusNumber);
        if (hasExactMatch) {
            throw new IllegalArgumentException(DUPLICATE_BONUS.getMessage());
        }

        return Integer.parseInt(bonus);
    }

    public static void blankCheck(String strLotto) {
        if (strLotto.isEmpty() || strLotto.equals(",")) {
            throw new IllegalArgumentException(BLANK.getMessage());
        }
    }

    public static void lottoPriceCheck(Integer buyPrice) {
        if (buyPrice % THOUSAND.getNumber() != ZERO.getNumber()) {
            throw new IllegalArgumentException(PRICE_CHECK.getMessage());
        }
    }

    public static void onlyNumberCheck(String inputData) {
        if (!(inputData != null && inputData.matches(ONLY_NUMBER_CHECK))) {
            throw new IllegalArgumentException(ONLY_NUMBER.getMessage());
        }
    }
}
