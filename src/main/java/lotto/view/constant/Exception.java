package lotto.view.constant;

public class Exception {
    public static final String COST_MOD = "[ERROR] 구매금액은 1,000원 단위여야 합니다.";
    public static final String COST_MIN = "[ERROR] 구매금액은 1,000원 이상이어야 합니다.";
    public static final String COST_FORMAT = "[ERROR] 20억 이하의 숫자를 입력해주세요.";
    public static final String LOTTO_FORMAT = "[ERROR] 로또 번호는 쉼표로 구분되는 1에서 45 사이의 숫자여야 합니다.";
    public static final String LOTTO_DUPLICATED = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final String LOTTO_SIZE = "[ERROR] 로또 번호는 6자리여야 합니다.";
    public static final String BONUS_FORMAT = "[ERROR] 보너스 번호는 하나의 숫자여야 합니다.";
    public static final String BONUS_DUPLICATED = "[ERROR] 보너스 번호는 중복될 수 없습니다.";
}
