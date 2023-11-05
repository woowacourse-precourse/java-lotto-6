package lotto.util;

import lotto.config.LottoConfig;

import java.util.HashSet;
import java.util.List;

public class Validator {

    public static int validateAndParseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력이 정수가 아닙니다.");
        }
    }



    public static void validateMoneyInput(List<Integer> numbers) {


    }

    public static void validateLottoNumbers(List<Integer> numbers) {

        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public static void validateWinningNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNotNull(number);
        }

        if (numbers.size() != LottoConfig.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        validateNumbersInRange(numbers);
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private static void validateNotNull(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("[ERROR] 숫자가 입력되지 않았습니다.");
        }
    }

    private static void validateNumberInRange(int number) {
        if (number < LottoConfig.START_OF_LOTTO_NUMBER.getValue()
                || number > LottoConfig.END_OF_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateNumbersInRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(num -> num >= LottoConfig.START_OF_LOTTO_NUMBER.getValue()
                && num <= LottoConfig.END_OF_LOTTO_NUMBER.getValue())) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateUniqueNumbers(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }
}
