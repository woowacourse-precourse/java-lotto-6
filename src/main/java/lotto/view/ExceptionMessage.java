package lotto.view;

public class ExceptionMessage {
    // 구매 금액
    // 1,000원 단위
    private static final String NOT_DIVISIBLE_NUMBER = "[ERROR] 금액은 1,000원 단위만 가능합니다.";
    // 숫자만 가능
    private static final String NOT_NUMBER_ERROR = "[ERROR] 금액은 숫자만 가능합니다.";
    // 금액 > 0
    private static final String NOT_NATURAL_NUMBER_ERROR = "[ERROR] 입력값은 0 이상이어야 합니다.";


    // 당첨 번호
    // 6자리가 아닌 것
    private static final String NOT_SIX_SIZE = "[ERROR] 당첨번호 6개를 입력해야 합니다.";
    // 숫자가 아닌 것이 포함되어 있을 때
    private static final String NOT_NUMBER_TYPE = "[ERROR] 정수형의 숫자 타입만 가능합니다.";
    // 1~45가 아닌 숫자가 포함되어 있을 때
    private static final String NOT_NUMBER_RANGE = "[ERROR] 1~45 사이 숫자만 가능합니다.";
    //
    private static final String NOT_PROPER_WINNING_NUMBERS = "[ERROR] 당첨번호로 올바르지 않습니다.";

    // 보너스 번호
    // 숫자가 아닌 것
    // 중복된 번호
    private static final String DUPLICATED_NUMBER = "[ERROR] 중복된 숫자는 입력 불가합니다.";

    public static String sizeException(){
        return NOT_SIX_SIZE;
    }

    public static String divisibleException() {
        return NOT_DIVISIBLE_NUMBER;
    }

    public static String numberException() {
        return NOT_NUMBER_TYPE;
    }

    public static String notNaturalNumberException(){
        return NOT_NATURAL_NUMBER_ERROR;
    }

    public static String notNumberException() {
        return NOT_NUMBER_ERROR;
    }

    public static String duplicatedNumberException(){
        return DUPLICATED_NUMBER;
    }

    public static String notProperWinningNumbersException(){
        return NOT_PROPER_WINNING_NUMBERS;
    }

    public static String rangeException(){
        return NOT_NUMBER_RANGE;
    }
}
