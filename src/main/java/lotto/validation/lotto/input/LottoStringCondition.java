package lotto.validation.lotto.input;


import java.util.regex.Pattern;
import lotto.validation.ValidationCondition;

public class LottoStringCondition extends ValidationCondition {
    private static final Pattern PATTERN = Pattern.compile("(\\d{1,2},){5}\\d{1,2}");
    private static final String EXCEPTION_MSG = "로또 번호의 형식이 올바르지 않습니다.";


    @Override
    protected void validateCondition(Object obj) {
        String lottoNumString = (String) obj;

        if (!PATTERN.matcher(lottoNumString).matches()) {
            throw new IllegalArgumentException(ERROR_MSG + EXCEPTION_MSG);
        }
    }

    @Override
    protected boolean isObjectOf(Object obj) {
        return obj instanceof String;
    }
}
