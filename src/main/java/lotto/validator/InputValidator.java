package lotto.validator;

public class InputValidator {
    private static final String NOT_NUMBER_MESSAGE = "[ERROR] 입력이 숫자로 이루어지지 않았습니다!";
    private static final String OVER_RANGE_MESSAGE = "[ERROR] 입력가능한 숫자의 범위를 넘었습니다!";
    private static final String NEGATIVE_NUMBER_MESSAGE = "[ERROR] 음수가 입력되었습니다!";
    private static final String NUMBER_REGEX = "[0-9]+";

    public static void onlyNumber(String input) {
        if (isNotMatchRegex(input, NUMBER_REGEX)) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }

    //긍적의 조건문을 나타내기위한 함수 필요한가?
    private static boolean isNotMatchRegex(String input, String regex) {
        if (input.matches(regex)) {
            return false;
        }
        return true;
    }

    public static void inRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(OVER_RANGE_MESSAGE);
        }
    }


    //try 처리 안해줘도될까
    public static void notNegative(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {   //0보다작다는 의미를 그냥 코드를 보고 이해할 수 있는데 상수 처리가 필요할까
            throw new IllegalArgumentException(NEGATIVE_NUMBER_MESSAGE);
        }
    }
}
