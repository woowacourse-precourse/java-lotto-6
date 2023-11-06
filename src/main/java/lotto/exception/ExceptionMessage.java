package lotto.exception;

import lotto.constant.LottoConstant;

public class ExceptionMessage {

    private ExceptionMessage() {
    }

    public static final String INVALID_LOTTO_NUMBER_FORMAT =
            "번호는 숫자여야 합니다.";
    public static final String LOTTO_NUMBER_OUT_OF_BOUND =
            "번호는 " + LottoConstant.LOTTO_START_NUMBER + " 이상, "
                    + LottoConstant.LOTTO_END_NUMBER + " 이하여야 합니다.";

    public static final String LOTTO_NUMBER_DUPLICATED =
            "중복된 번호를 입력할 수 없습니다.";

    public static final String INVALID_LOTTO_NUMBER_COUNT =
            "로또 번호는 " + LottoConstant.LOTTO_NUMBER_COUNT + "개여야 합니다.";

    public static final String NON_POSITIVE_PURCHASE_AMOUNT =
            "로또 구입 금액은 양수여야 합니다.";

    public static final String NOT_DIVISIBLE_BY_LOTTO_TICKET_PRICE =
            "로또 구입 금액은 " + LottoConstant.LOTTO_TICKET_PRICE + "원 단위여야 합니다.";
}
