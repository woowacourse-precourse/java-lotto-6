package lotto.Validator;

import java.util.regex.Pattern;

public abstract class Validator<T> {

    public abstract T valid(T input);

    protected boolean isNumber(String input) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        return pattern.matcher(input).matches();
    }
}
