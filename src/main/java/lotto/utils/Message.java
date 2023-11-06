package lotto.utils;

public class Message {
    // 안내 메시지
    public static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요. ";
    public static final String LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요. ";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요. ";
    public static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";


    // 예외 사항 메시지
    private static final String ERROR = "[ERROR] ";
    // 구매금액 관련 예외 메시지
    public static final String NON_NUMERIC_EXCEPTION_MESSAGE = ERROR + "숫자만 입력해주세요. ";
    public static final String ZERO_EXCEPTION_MESSAGE = ERROR + "0보다 큰 숫자를 입력해주세요. ";
    public static final String INDIVISIBLE_BY_UNIT_PRICE_EXCEPTION_MESSAGE = ERROR + "구입 단위에 맞는 금액을 입력해주세요. 구입 단위: ";

    // 당첨 번호 관련 예외 메시지
    public static final String INVALID_LOTTO_NUMBER_COUNT_EXCEPTION = ERROR + "올바른 수의 당첨 번호를 입력해주세요. ";
    public static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = ERROR + "1에서 45 사이의 수를 입력해주세요. ";
    public static final String DUPLICATED_NUMBER_EXCEPTION_MESSAGE = ERROR + "중복되지 않은 수를 입력해주세요. ";
}
