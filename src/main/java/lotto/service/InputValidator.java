package lotto.service;

import java.util.Arrays;

public class InputValidator {
    public static void validateOrderPrice(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 수로 입력해야 한다.");
        }
        if (!input.matches("[1-9]+0{3}$")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 한다.");
        }
    }

    public static void validateLottoNumbers(String input) {
        if (!input.matches("^([1-9]{1},|[1-3]{1}[0-9]{1},|4{1}[0-5]{1},)" +
                "{5}([1-9]{1}|[1-3]{1}[0-9]{1}|4{1}[0-5]{1})$")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 1~45의 쉼표(,)로 " +
                    "구분된 문자열로 입력해야 한다.");
        }
        if (input.split(",").length != Arrays.stream(input.split(",")).distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 입력되는 로또 번호는 중복되면 안된다.");
        }
    }

    public static void validateBonusNumber(String input) {
        if (!input.matches("^[0-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45의 수를 입력해야 한다.");
        }
    }
}
