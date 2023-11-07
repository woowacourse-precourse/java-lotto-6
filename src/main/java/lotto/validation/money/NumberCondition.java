package lotto.validation.money;

import lotto.validation.ValidationCondition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberCondition extends ValidationCondition {
    private static final String numberRegex = "[^0-9]";

    @Override
    public void isSatisfiedBy(String money) {

        Pattern pattern = Pattern.compile(numberRegex);
        Matcher matcher = pattern.matcher(money);

        if (matcher.find()) {
            throw new IllegalArgumentException(ERROR_MSG + "입력 문자열에 숫자 이외의 문자가 포함되어 있습니다.");
        }

    }
}
