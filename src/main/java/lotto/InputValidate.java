package lotto;

import static java.lang.Integer.parseInt;

public class InputValidate {
    public boolean isThereGap(String input) {
        try {
            parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다. 프로그램이 종료됩니다.");
        }
        return true;
    }

    public int changeInt(String s){
        return parseInt(s);
    }


}
