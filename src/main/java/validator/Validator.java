package validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public void checkStartOrEndWithComma(String input) throws IllegalArgumentException {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 형식입니다.");
        }
    }

    public void checkCount(List<String> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력 갯수가 잘못되었습니다.");
        }
    }

    public void checkDuplicateNumber(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> uniques = new HashSet<Integer> ();
        for(Integer number : numbers) {
            if (!uniques.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 값이 있습니다.");
            }
        }

    }

}
