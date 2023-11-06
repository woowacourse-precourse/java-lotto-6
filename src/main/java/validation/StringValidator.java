package validation;

import lotto.Const;

public class StringValidator {

    private StringValidator() {
    }

    // 문자열이 Integer 인지 확인 후 맞으면 int 형으로 반환
    public static int checkIntegerType(final String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 정수 형식으로 입력해야 합니다.");
        }
    }
}
