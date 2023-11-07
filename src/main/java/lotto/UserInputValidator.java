package lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputValidator {

    private static final String REGEXP_ONLY_NUM = "^[1-9][0-9]*$";
    private static final Pattern ONLY_NUM = Pattern.compile(REGEXP_ONLY_NUM);

    private static final String REGEXP_VALIDATE_LOTTO = "^[1-9][0-9]*(,[1-9][0-9]*)*$";
    private static final Pattern WINNING_LOTTO = Pattern.compile(REGEXP_VALIDATE_LOTTO);

    public static void validateNum(String amount) {
        Matcher matcher = ONLY_NUM.matcher(amount);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자로만 입력해주세요");
        }
    }

    public static void validateNull(String amount) {
        if (amount == null || amount.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 값을 입력할 수 없습니다.");
        }
    }

    public static void validateWinningLotto(String lotto) {
        Matcher matcher = WINNING_LOTTO.matcher(lotto);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 번호 입니다" + "공백없이 구분자 ,를 넣어 입력하세요.");
        }
    }
}
