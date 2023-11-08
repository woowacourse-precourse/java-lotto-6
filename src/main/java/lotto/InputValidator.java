package lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidator {

    public static void validateIsNumeric(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }

        for (char c: input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
            }
        }
    }

    public static void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 번호는 6개가 되야합니다.");
        }
    }

    public static void validateIsLottoNumber(int number) {
        if (number < 0 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 0에서 45사이의 숫자여야 합니다.");
        }
    }

    public static void validateDivision1000(int number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    public static void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> set = numbers.stream().collect(Collectors.toSet());

        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 번호가 중복되었습니다.");
        }
    }

    public static void validateBonusNumberNoDuplicate(List<Integer> lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 겹칩니다.");
        }
    }
}
