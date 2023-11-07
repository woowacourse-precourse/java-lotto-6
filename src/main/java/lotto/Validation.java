package lotto;

import java.util.List;

public class Validation {
    public static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    public static void isAllValidNumbers (List<String> original) {
        for (String previous: original){
            int num = Integer.parseInt(previous);
            validateNumberRange(num);
        }
    }

    public static void validateNumberRange(int num){
        if (num > 45 || num < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
