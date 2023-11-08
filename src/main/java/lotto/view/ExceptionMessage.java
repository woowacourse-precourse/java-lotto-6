package lotto.view;

public class ExceptionMessage {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_MIN_AMOUNT = 1000;
    public static final String ERROR = "[ERROR] ";
    public static final String NOT_NUMBER_RANGE_ERROR = ERROR + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이의 숫자여야 합니다.";
    public static final String NOT_NUMBER_DUPLICATED_ERROR = ERROR + "중복된 숫자를 입력하셨습니다.";
    public static final String PRIZE_NUMBER_FORMAT_ERROR = ERROR + "당첨 번호는 6개의 숫자와 ','로 구분되어야 합니다.";
    public static final String INPUT_NUMBER_RANGE_ERROR = ERROR + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이의 숫자여야 합니다.";
    public static final String NOT_NUMBER_ERROR = ERROR + "숫자만 등록 가능합니다.";
    public static final String NOT_NATURAL_NUMBER_ERROR = ERROR + "금액은 0 초과이어야 합니다.";
    public static final String NOT_DIVISIBLE_NUMBER_ERROR = ERROR + "금액은 " + LOTTO_MIN_AMOUNT + "단위여야 합니다.";

    public static void numberException() {
        System.out.println(NOT_NUMBER_ERROR);
    }
}
