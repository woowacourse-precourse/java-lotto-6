package lotto.global;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static boolean purchasePriceFormat(String input) {
        if (!input.matches("^(\\d+000)$")) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력받으며 1,000원으로 나누어떨어져야 합니다.\n");
        }

        return true;
    }

    public static boolean lottoNumbersWithString(List<String> lottoNumbers) {
        lottoNumbersCountWithString(lottoNumbers);
        lottoNumbersFormatWithString(lottoNumbers);
        lottoNumbersDuplicateWithString(lottoNumbers);

        return true;
    }

    public static void lottoNumbersWithInteger(List<Integer> lottoNumbers) {
        lottoNumbersCountWithInteger(lottoNumbers);
        lottoNumbersFormatWithInteger(lottoNumbers);
        lottoNumbersDuplicateWithInteger(lottoNumbers);
    }

    public static boolean bonusNumber(String input, List<String> winningNumbers) {
        lottoNumberFormat(input);
        bonusNumberDuplicate(input, winningNumbers);

        return true;
    }

    private static void lottoNumbersCountWithString(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 쉼표(,)를 기준으로 6개여야 합니다.\n");
        }
    }

    private static void lottoNumbersFormatWithString(List<String> numbers) {
        for (String number : numbers) {
            lottoNumberFormat(number);
        }
    }

    private static void lottoNumbersDuplicateWithString(List<String> numbers) {
        Set<String> noDuplicateNumbers = new HashSet<>(numbers);

        if (noDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않는 숫자 6개여야 합니다.\n");
        }
    }

    private static void lottoNumbersCountWithInteger(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 쉼표(,)를 기준으로 6개여야 합니다.\n");
        }
    }

    private static void lottoNumbersFormatWithInteger(List<Integer> numbers) {
        for (Integer number : numbers) {
            lottoNumberFormat(String.valueOf(number));
        }
    }

    private static void lottoNumbersDuplicateWithInteger(List<Integer> numbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);

        if (noDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않는 숫자 6개여야 합니다.\n");
        }
    }

    private static void lottoNumberFormat(String input) {
        if (!input.matches("^([1-9]|[1-3][0-9]|4[0-5])$")) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.\n");
        }
    }

    private static void bonusNumberDuplicate(String input, List<String> winningNumbers) {
        for (String number : winningNumbers) {
            if (input.equals(number)) {
                throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.\n");
            }
        }
    }
}
