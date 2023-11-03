package lotto.util;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern NUMBER=Pattern.compile("[0-9]+");
    public void numberValidate(String value){
        if(!NUMBER.matcher(value).matches()){
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
    }
}
