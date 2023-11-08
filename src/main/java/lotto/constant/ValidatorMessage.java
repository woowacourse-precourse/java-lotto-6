package lotto.constant;

public class ValidatorMessage {
    public final static String INVALID_LOTTO_SIZE = "[ERROR] 번호는 6개를 입력해야 합니다.";
    public final static String INVALID_LOTTO_DUPLICATE = "[ERROR] 번호는 중복숫자가 없어야 합니다.";
    public final static String INVALID_IS_NULL = "[ERROR] 값을 입력해주세요.";
    public final static String INVALID_LOTTO_RANGE =
            "[ERROR] 로또 번호는 " + Number.MIN_NUMBER + "부터 " + Number.MAX_NUMBER + "사이 값을 입력해야 합니다.";
    public final static String INVALID_LOTTO_NUMERIC = "[ERROR] 번호는 숫자를 입력해야 합니다.";
    public final static String INVALID_WIN_NUMBER_IS_NUMERIC = "[ERROR] 당첨 번호은 쉼표(\",\")로 구분해주세요.";
    public final static String INVALID_BONUS_DUPLICATE_WIN_LOTTO = "[ERROR] 보너스 번호는 당첨 번호들과 다른 번호를 입력해야 합니다.";
    public final static String INVALID_BONUS_NUMERIC = "[ERROR] 보너스 번호는 숫자를 입력해야 합니다.";
    public final static String INVALID_BONUS_RANGE =
            "[ERROR] 보너스 번호는 " + Number.MIN_NUMBER + "부터 " + Number.MAX_NUMBER + "사이 값을 입력해야 합니다.";
    public final static String INVALID_INPUT_NUMERIC = "[ERROR] 숫자를 입력하세요.";
    public final static String INVALID_COST_POSITIVE = "[ERROR] 0보다 큰 숫자를 입력하세요.";
    public final static String INVALID_LOTTO_COST = "[ERROR] 로또 1장 가격은 1000원 입니다. 1000원 단위로 입력해주세요.";
    public final static String INVALID_INPUT_COST = "[ERROR] 보너스 번호를 입력해주세요.";
    public final static String INVALID_INPUT_WIN_LOTTO_NUMBER = "[ERROR] 당첨 번호를 입력해주세요.";
    public final static String INVALID_INPUT_BONUS_NUMBER = "[ERROR] 보너스 번호를 입력해주세요.";
}
