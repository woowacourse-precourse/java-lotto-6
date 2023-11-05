package lotto;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;

public class ValidateNumber {
    public static ThrowingCallable isNumber(String s) {
        if (s.matches("\\d+")) {
            return null;
        }
        throw new IllegalArgumentException("[ERROR] 숫자만 입력 해주세요.");
    }
}
