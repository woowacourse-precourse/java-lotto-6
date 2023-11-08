package lotto.validation.money.input;

import java.util.regex.Pattern;
import lotto.validation.ValidationCondition;

public class NumberCondition extends ValidationCondition {
    private static final Pattern PATTERN = Pattern.compile("[^0-9]");
    private static final String EXCEPTION_MSG = "입력 문자열에 숫자 이외의 문자가 포함되어 있습니다.";

    @Override
    protected void validateCondition(Object obj) {
        String moneyString = (String) obj;

        if (PATTERN.matcher(moneyString).matches()) {
            throw new IllegalArgumentException(ERROR_MSG + EXCEPTION_MSG);
        }
    }

    @Override
    protected boolean isObjectOf(Object obj) {
        return obj instanceof String;
    }

}
