package lotto.common.message;

public class ExceptionMessage {
    public static final String OVER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복을 허용하지 않습니다.";
    public static final String BLANK = "[ERROR] 로또 번호는 공백 입력이 불가능합니다.";
    public static final String INPUT_PRICE = "[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.";
    public static final String NON_NUMBER = "[ERROR] 로또 번호 및 금액은 숫자만 입력 가능합니다.";
    public static final String OVER_SIZE = "[ERROR] 로또 번호는 6개의 숫자로 이루어져야 합니다.";
    public static final String WINNING_NUMBER = "[ERROR] 당첨 번호는 6개의 숫자여야 하며, 쉼표로 구분되어야 합니다.";
}
