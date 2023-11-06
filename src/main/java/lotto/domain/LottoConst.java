package lotto.domain;

public class LottoConst {

    public static final int LOTTO_PRICE = 1000;
    public static final String NOT_PURCHASE_MONEY_OVER_1000 = "[ERROR] 1000원 이상 입력해 주세요.";
    public static final String NOT_PURCHASE_MONEY_DIVIDE_1000 = "[ERROR] 1000원 단위로 입력해 주세요.";
    public static final String NOT_INPUT_NUMBER = "[ERROR] 숫자를 입력해 주세요.";

    public static final int LOTTO_SIZE = 6;
    public static final String NOT_LOTTO_SIZE = "[ERROR] 당첨번호를 6개 입력해 주세요.";

    public static final int LOTTO_MIN_NUM = 1;
    public static final int LOTTO_MAX_NUM = 45;
    public static final String NOT_INPUT_NUM_IN_RANGE = "[ERROR] 당첨번호는 1부터 45까지 숫자 중에서 입력해 주세요.";

    public static final String NOT_INPUT_WINNING_NUMS_NUMBER = "[ERROR] 당첨번호를 올바르게 입력해 주세요.";
    public static final String DUPLICATE_NUMS = "[ERROR] 번호가 중복되었습니다. 다시 입력해주세요.";

    public static final String INPUT_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUM = "보너스 번호를 입력해 주세요.";
}
