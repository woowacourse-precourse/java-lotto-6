package lotto.Validator;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    private static final String SEPARATOR = ",";

    public static void validateBlankString(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 문자열이 입력되었습니다");
        }
    }

    public static String[] seperateStrings(String input) {
        return input.split(SEPARATOR);
    }

    public static List<Integer> getListOfIntegerByStrings(String[] inputs) {
        List<Integer> numbers = new ArrayList<>();
        try {
            for (String number :
                    inputs) {
                numbers.add(Integer.parseInt(number));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해주세요");
        }
        return numbers;
    }

    public static void validateMoney(long money){
        if(money <= 0 || money > 21 * Math.pow(10, 8))
                throw new IllegalArgumentException("[ERROR] 금액은 유효한 값으로 입력해주세요.");
        if(money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해주세요");

    }
}
