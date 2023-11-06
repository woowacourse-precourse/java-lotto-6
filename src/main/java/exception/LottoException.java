package exception;

public class LottoException {

    public static final String NOT_NUMBER = "[ERROR] 로또 구입 금액이 숫자가 아닙니다.";
    public static final String NOT_POSITIVE_NUMBER = "[ERROR] 로또 구입 금액이 0 또는 음수입니다.";
    public static final String NOT_DIVIDE_LOTTO_TICKET_PRICE = "[ERROR] 로또 구입 금액이 1,000원으로 나누어 떨어지지 않습니다.";
    public static final String DUPLICATE_LOTTO_NUMBERS = "[ERROR] 중복된 숫자를 입력하셨거나 로또 번호 개수는 6개여야 합니다.";
    public static final String NOT_LOTTO_NUMBER_FROM_MIN_TO_MAX = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
}
