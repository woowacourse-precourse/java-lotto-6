package lotto.exception;

public class Message {
    public static final String CANNOT_BUY_LOTTO_EXCEPTION = "[ERROR] 돈으로 로또를 살 수 없습니다.";
    public static final String MONEY_CREATION_EXCEPTION = "[ERROR] 돈이 0원 미만입니다!";
    public static final String NUMBER_OUT_OF_RANGE_EXCEPTION = "[ERROR] 로또 숫자가 유효 범위를 벗어났습니다.";
    public static final String NUMBER_DUPLICATION_EXCEPTION = "[ERROR] 숫자에 중복이 존재합니다!";
    public static final String LOTTO_OUT_OF_SIZE_EXCEPTION = "[ERROR] 로또로 발행할 수 있는 숫자 범위를 벗어났습니다.";
    public static final String BONUS_NUMBER_RANGE_EXCEPTION = "[ERROR] 보너스 숫자가 유효 범위 내에 존재하지 않습니다.";
    public static final String BONUS_NUMBER_DUPLICATION_EXCEPTION = "[ERROR] 보너스 숫자가 당첨 로또의 숫자가 겹칩니다.";
}
