package lotto.util.constant;

public class InvalidConstant {

    public static final String ERROR_MESSAGE = "[ERROR] ";

    // 랭킹
    public static final String OUT_OF_RANKING_INDEX = "잘못된 랭킹입니다. 랭킹은 1등부터 5등 사이여야 합니다.";
    public static final String INVALID_DIVIDE_ZERO = "잘못된 값입니다. 0으로 나눌 수 없습니다.";

    // 구매 금액
    public static final String INVALID_INPUT_FORMAT = "숫자를 입력해주세요.";
    public static final String INVALID_THOUSAND_UNIT = "구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String INVALID_INPUT_RANGE = "구입 금액은 1,000원 이상 입력해야 합니다.";

    // 로또 당첨 번호
    public static final String INVALID_UNIQUE_WINNING_NUMBERS = "입력한 로또 당첨 번호 중 중복된 숫자가 존재합니다.";
    public static final String INVALID_SIZE_WINNING_NUMBERS = "로또 당첨 번호는 6개 입력해야 합니다.";
    public static final String INVALID_RANGE_WINNING_NUMBERS = "입력한 로또 당첨 번호는 1 ~ 45 사이의 숫자여야 합니다.";

    // 보너스 번호
    public static final String INVALID_RANGE_BONUS_NUMBER = "입력한 보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.";
    public static final String INVALID_DUPLICATE_BONUS_NUMBER = "입력한 보너스 번호는 로또 당첨 번호와 중복된 숫자가 존재합니다.";


}
