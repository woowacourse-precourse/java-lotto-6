package lotto.constants;

public final class Constant {
    public static final int COUNT_LOTTO_NUMBER = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_PRICE = 1000;
    public static final int PERCENTAGE = 100;

    //ERROR
    public static final String ERROR = "[ERROR] ";
    public static final String NUMBER_ERROR_MESSAGE = "숫자만 입력가능합니다.";
    public static final String NATURAL_ERROR_MESSAGE = "최소금액은 " + LOTTO_PRICE + "원 입니다.";
    public static final String DIVISIBLE_ERROR_MESSAGE = LOTTO_PRICE + "원 단위로 입력하세요.";
    public static final String NUMBER_RANGE_ERROR_MESSAGE = "숫자는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + "사이의 숫자여야합니다.";
    public static final String NUMBER_SIZE_ERROR_MESSAGE = "당첨 번호는 총 6개 입력 가능합니다.";
    public static final String NUMBER_OVERLAP_ERROR_MESSAGE = "중복된 숫자를 입력하셨습니다.";

}
