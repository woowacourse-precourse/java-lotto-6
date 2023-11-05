package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private final int THOUSAND = 1000;
    private final int ZERO = 0;


    public void checkIsNumber(String input) throws IllegalArgumentException {
        Matcher matcher = NUMBER_PATTERN.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닙니다.");
        }
    }

    public void checkMinMoney(int input) throws IllegalArgumentException {
        if (input < THOUSAND) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력해 주세요.");
        }
    }

    public void checkDividedByThousand(int amount) throws IllegalArgumentException {
        if (Math.floorMod(amount, THOUSAND) != ZERO) {
            throw new IllegalArgumentException("[ERROR] 1,000원의 단위로 입력해 주세요.");
        }
    }


}
