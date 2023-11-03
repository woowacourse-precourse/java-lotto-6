package lotto.domain.util;

import static lotto.exception.ErrorMessage.*;

import java.util.*;
import java.util.regex.Pattern;
import lotto.domain.Lotto;
import lotto.exception.LottoException;

public final class LottoParser {
    private static final String LOTTO_NUMBER_REGEX = "^(\\d+,)+\\d+$";
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    private LottoParser() {}

    public static int parseMoneyToLottoCount(String moneyInput) {
        int parsedMoney = Integer.parseInt(moneyInput);
        validateMoney(parsedMoney);
        return parsedMoney / LOTTO_PRICE;
    }

    public static List<Integer> parseWinningNumbers(String winningNumbers) {
        validateLottoNumbers(winningNumbers);
        return numbersStringToList(winningNumbers);
    }

    public static int parseBonusNumber(String bonusInput) {
        validateBonusNumber(bonusInput);
        return Integer.parseInt(bonusInput);
    }

//    public static List<List<Integer>> parseLottoToInteger(List<Lotto> lottos) {
//        //
//    }

    public static void validateMoney(int parsedMoney) {
        if (parsedMoney < LOTTO_PRICE) {
            throw new LottoException(LOTTO_MONEY_INPUT_SMALL_ERROR);
        }
        if (parsedMoney % LOTTO_PRICE != 0) {
            throw new LottoException(LOTTO_MONEY_INPUT_ERROR);
        }
    }

    private static void validateLottoNumbers(String numbersInput) {
        if (!Pattern.matches(LOTTO_NUMBER_REGEX, numbersInput)) {
            throw new LottoException(LOTTO_NUMBER_FORMAT_ERROR);
        }
        List<Integer> numbers = numbersStringToList(numbersInput);
        validateLottoNumbersList(numbers);
    }

    private static void validateBonusNumber(String bonusNumberInput) {
        if (!isOverRangedNumber(Integer.parseInt(bonusNumberInput))) {
            throw new LottoException(LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    public static void validateLottoNumbersList(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new LottoException(LOTTO_NUMBER_COUNT_ERROR);
        }
        if (hasDuplicatedNumber(numbers)) {
            throw new LottoException(LOTTO_NUMBER_DUPLICATED_ERROR);
        }
        if (hasOverRangedNumber(numbers)) {
            throw new LottoException(LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    private static List<Integer> numbersStringToList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public static boolean hasDuplicatedNumber(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

    public static boolean hasOverRangedNumber(List<Integer> numbers) {
        return !numbers.stream()
                .allMatch(LottoParser::isOverRangedNumber);
    }

    private static boolean isOverRangedNumber(int number) {
        return (number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);
    }
}
