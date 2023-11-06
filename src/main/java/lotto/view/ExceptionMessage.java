package lotto.view;

public class ExceptionMessage {
    private static int LOTTO_MIN_NUMBER = 1;
    private static int LOTTO_MAX_NUMBER = 45;
    private static final String NOT_INPUT_TYPE = "[ERROR] 입력은 숫자로만 이루어져야 합니다.";
    private static final String NOT_INPUT_MONEY_UNIT = "[ERROR] 로또 구입 금액 입력은 1,000원 단위로 입력해야합니다.";
    private static final String NOT_LOTTO_LENGTH = "[ERROR] 입력의 길이가 옳지 않습니다.";
    private static final String NOT_NUMBER_RANGE = "[ERROR] 옳지 않은 숫자 범위 입니다. 범위는 " + LOTTO_MIN_NUMBER + "에서" + LOTTO_MAX_NUMBER + "까지 입니다.";
    private static final String IS_DUPLICATE = "[ERROR] 입력한 숫자에 중복이 있습니다.";

    public static void typeException(){
        System.out.println(NOT_INPUT_TYPE);
    }

    public static void unitException(){
        System.out.println(NOT_INPUT_MONEY_UNIT);
    }

    public static void lengthException(){
        System.out.println(NOT_LOTTO_LENGTH);
    }

    public static void rangeException(){
        System.out.println(NOT_NUMBER_RANGE);
    }

    public static void duplicateException(){
        System.out.println(IS_DUPLICATE);
    }
}
