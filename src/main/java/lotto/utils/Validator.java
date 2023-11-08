package lotto.utils;

import static lotto.utils.Constant.LOTTO_MAXIMUM;
import static lotto.utils.Constant.LOTTO_MINIMUM;
import static lotto.utils.Constant.LOTTO_PRICE;
import static lotto.utils.Constant.LOTTO_SIZE;
import static lotto.utils.Constant.ZERO;

import java.util.HashSet;
import java.util.List;

public class Validator {

    public static void isDigit(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자가 입력되었습니다.");
        }
    }

    public static void canDivideByKilo(String input) {
        if (Integer.parseInt(input) % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException("[ERROR] 천 원단위로 입력해 주세요.");
        }
    }

    public static void isMoneyOverKilo(String input) {
        if (Integer.parseInt(input) < 1000) {
            throw new IllegalArgumentException("[ERROR] 한 장도 구입할 수 없습니다.");
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자로 이루어져야 합니다.");
        }
    }

    public static void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> duplicationChecker = new HashSet<>(numbers);

        if (duplicationChecker.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 입력되었습니다");
        }
    }

    public static void validateFittingInRange(int number) {
        if (number < LOTTO_MINIMUM || number > LOTTO_MAXIMUM) {
            throw new IllegalArgumentException("[ERROR] 1에서 45사이 숫자만 허용됩니다.");
        }
    }
}

