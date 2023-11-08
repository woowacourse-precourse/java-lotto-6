package lotto;

import java.util.List;
import java.util.Set;

public class InputValidation {

    static int lottoRangeFirstNum = 1;
    static int lottoRangeLastNum = 45;

    int toInt(String str) {
        isPositiveNum(str);
        return Integer.parseInt(str);
    }

    void isPositiveNum(String input) {
        String regex = "^([1-9]+[0-9]*)$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 0보다 큰 숫자여야 합니다.");
        }
    }

    void isWithinRange(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (!(num >= lottoRangeFirstNum && num <= lottoRangeLastNum)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1~45입니다.");
            }
        }
    }

    void isWithinRange(int num) {
        if (!(num >= lottoRangeFirstNum && num <= lottoRangeLastNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위는 1~45입니다.");
        }
    }

    void isBonusDuplicateOfLotto(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 입력한 로또 번호와 중복될 수 없습니다.");
        }
    }

    void hasDuplicateNum(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        }
    }
}
