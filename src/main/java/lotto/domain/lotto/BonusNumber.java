package lotto.domain.lotto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BonusNumber {
    private static final Pattern bonusNumberRegex = Pattern.compile("\\d");

    private final int number;

    public BonusNumber(String bonusNumber) {
        validate(bonusNumber);
        this.number = parseBonusNum(bonusNumber);
    }

    public int getNumber() {
        return number;
    }

    private void validate(String bonusNumber) {
        validateFormat(bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateFormat(String bonusNumber) {
        Matcher matcher = bonusNumberRegex.matcher(bonusNumber);
        boolean isNotMatch = !matcher.matches();

        if (isNotMatch) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 숫자만 입력해야 합니다.");
        }
    }

    private void validateRange(String bonusNumber) {
        int bonusNum = parseBonusNum(bonusNumber);

        if (isInvalidRange(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1~45사이의 숫자여야 합니다.");
        }
    }

    private static int parseBonusNum(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    private boolean isInvalidRange(int bonusNum) {
        return bonusNum < 1 || bonusNum > 45;
    }
}
