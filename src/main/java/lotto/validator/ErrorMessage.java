package lotto.validator;

import lotto.constant.Prize;

public class ErrorMessage {
    public static final String ERROR_MESSAGE_PREFIX = "[ERROR]";
    public static final String ERROR_PURCHASE_AMOUNT_UNIT = "구매 금액의 단위가 올바르지 않습니다. 재입력 해주세요";
    public static final String ERROR_NOT_NUMERIC = "숫자를 입력해야합니다. 재입력 해주세요";
    public static final String ERROR_RANGE_LOTTO_NUMBER = "로또 번호는 1부터 45 사이의 숫자여야 합니다. 재입력 해주세요";
    public static final String ERROR_SIX_LOTTO_NUMBER = "입력 개수가 올바르지 않습니다. 6개를 재입력 해주세요";
    public static final String ERROR_ONLY_ONE_BONUS = "보너스 번호를 1개만 재입력 해주세요";
}
