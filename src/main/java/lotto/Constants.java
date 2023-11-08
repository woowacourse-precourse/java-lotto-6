package lotto;

public class Constants {
    public static final int LOTTO_PRICE = 1000; // 1개 로또 가격
    public static final String COMMA = ",";
    public static final int DECIMAL_PLACES = 2; // 소수점 반올림 자릿수
    public static final int MAX_LOTTO_SIZE = 6; // 로또 최대 번호 개수
    public static final int MIN_PRIZE_SIZE = 3; // 최소 일치 개수
    public static final int MAX_PRIZE_SIZE = 6; // 최대 일치 개수
    public static final int LOTTO_NUMBER_MIN = 1; // 로또 번호 최소 값
    public static final int LOTTO_NUMBER_MAX = 45; // 로또 번호 최대 값
    public static final String PURCHASE_AMOUNT_REGEX = "^[1-9]\\d*000$"; // 구입 금액 정규식 (0 이상의 정수이고 000으로 끝나야 함, 1000원 단위)
    public static final String INTEGER_REGEX = "^-?[0-9]*$"; // 정수 정규식 (0 이상의 정수)
    public static final String STATISTICS_HEADER = "당첨 통계\n---------\n"; // 당첨 통계 헤더
    public static final String TOTAL_YIELD_HEADER = "총 수익률은 "; // 총 수익률 헤더
    public static final String TOTAL_YIELD_TAIL = "%입니다."; // 총 수익률 꼬리
    public static final String DASH = " - "; // 하이픈
    public static final String AMOUNT = "개"; // 개
    public static final String PURCHASED_AMOUNT = "개를 구매했습니다."; // 개를 구매했습니다.
    public static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";// 당첨 번호를 입력해 주세요.
    public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";// 보너스 번호를 입력해 주세요.
    public static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";// 구입금액을 입력해 주세요.
    public static final String ERROR_PREFIX = "[ERROR] ";
}

