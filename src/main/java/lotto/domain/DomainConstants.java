package lotto.domain;

public class DomainConstants {

    public static final String SIX_NUMBERS_MESSAGE = "[ERROR] 6자리 숫자를 입력해 주세요.";
    public static final String UNIQUE_SIX_NUMBERS_MESSAGE = "[ERROR] 중복되지 않는 6자리 숫자를 입력해 주세요.";
    public static final String NUMBER_RANGE_MESSAGE = "[ERROR] 각 번호는 1 이상 45 이하로 입력해 주세요.";
    public static final String ONLY_NUMBER_MESSAGE = "[ERROR] 1000원 이상 숫자만 입력해 주세요.\n";
    public static final String ABOVE_THOUSAND_MESSAGE = "[ERROR] 1000원 이상 입력해 주세요.\n";
    public static final String DIVISIBLE_BY_THOUSAND_MESSAGE = "[ERROR] 1000원 단위로 입력해 주세요.\n";
    public static final String NO_BLANK_MESSAGE = "[ERROR] 공백은 입력이 불가능 합니다.";
    public static final String ONLY_NUMBERS_MESSAGE = "[ERROR] 숫자만 입력해 주세요.";
    public static final String ONLY_ONE_NUMBER_MESSAGE = "[ERROR] 0 이상 숫자 하나만 입력해 주세요.";
    public static final String BONUS_NUM_RANGE_MESSAGE = "[ERROR] 보너스 번호는 1 이상 45 이하로 입력해 주세요.";
    public static final String BONUS_NUM_DUPLICATE_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String BLANK = " ";

    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_MIN_NUM = 1;
    public static final int LOTTO_MAX_NUM = 45;
    public static final int LOTTO_NUMBERS = 6;
    public static final int PERCENTAGE = 100;
    public static final int WINNING_COUNT = 3;
    public static final int ZERO_CHANGE = 0;
}
