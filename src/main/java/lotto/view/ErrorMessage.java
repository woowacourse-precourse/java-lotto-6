package lotto.view;

public class ErrorMessage {
    private static final String NOT_PRICE="[ERROR] 1000단위로 안나누어집니다";

    private static final String NOT_INTEGER="[ERROR] 정수형을 입력해주세요";
    private static final String IS_DUPLICATION ="[ERROR] 중복된 값이 있습니다";
    private static final String IS_MAXANDMINVALUE="[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String IS_SPACE ="[ERROR] 공백이 있습니다 제대로 된 값을 입력해주세요";
    private static final String NOT_VALUES = "[ERROR] 길이가 6이 아닙니다 제대로 된값을 입력해주세요";
    public static String notPriceMessage() {
        return NOT_PRICE;
    }

    public static String notIntegerMessage() {
        return NOT_INTEGER;
    }

    public static String isDuplication() {
        return IS_DUPLICATION;
    }

    public static String isMaxAndMinValue() {
        return IS_MAXANDMINVALUE;
    }

    public static String isSpace() {
        return IS_SPACE;
    }

    public static String notValue() {
        return NOT_VALUES;
    }
}
