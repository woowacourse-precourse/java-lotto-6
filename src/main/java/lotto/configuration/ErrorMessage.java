package lotto.configuration;

public class ErrorMessage {
    public static final String INPUT_NOT_NUMBER = "[ERROR] 숫자를 입력해주세요.";
    public static final String NOT_ENOUGH_MONEY = "[ERROR] 구입금액은 1,000원 이상이어야 합니다.";
    public static final String UNIT_NOT_VALID = "[ERROR] 구입금액은 1,000원 단위여야 합니다.";
    public static final String NUMBER_DUPLICATED = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final String WRONG_LOTTO_NUMBER_LENGTH = "[ERROR] 로또 번호는 총 "
            + LottoConstants.LOTTO_NUMBER_LENGTH + "개 입니다.";
    public static final String LOTTO_NUMBER_NOT_IN_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
}