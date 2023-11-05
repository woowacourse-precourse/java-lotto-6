package lotto.domain;

public class ErrorMessage {

    public static final int LOTTO_MIN_MONEY_UNIT = 1000;
    public static final int LOTTO_MIN_UNIT = 0;
    public static final String MONEY_DIVIDE_UNIT_ERROR = "[ERROR] 금액은 " + LOTTO_MIN_MONEY_UNIT + "단위만 입력받을 수 있습니다.";
    public static final String CANT_BUY_LESS_THAN_ZERO = "[ERROR] 로또는 " + LOTTO_MIN_UNIT + "장 아래로 구매할 수 없습니다.";
    public static final String LOTTO_MUST_CONSIST_OF_NUMBERS = "[ERROR] 로또는 숫자 외의 값을 입력받을 수 없습니다.";
    public static final String LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또는 1 이상 45 이하의 값만 입력받을 수 있습니다.";
    public static final String LOTTO_NUMBER_DUPLICATE_ERROR = "[ERROR] 로또는 중복되는 값을 입력받을 수 없습니다.";
    public static final String BONUS_NUMBER_ALREADY_IN_WINNING_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
}
