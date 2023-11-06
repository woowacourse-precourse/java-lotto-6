package lotto.util.message;

import lotto.domain.Lotto;
import lotto.domain.LottoInfo;

public enum ExceptionMessage {
    NOT_NUMERIC("입력값을 다시 확인해주세요."),
    CHECK_UNIT_PRICE(String.format("%s원 단위로 입력해주세요.", Lotto.PRICE)),
    CHECK_RANGE_BONUS_NUM(String.format(
            "%s ~ %s 사이의 값만 가능합니다.",
            LottoInfo.MIN_NUMBER.getNumberInfo(),
            LottoInfo.MAX_NUMBER.getNumberInfo()
    )),
    CHECK_SIZE_NUM(String.format("%s개의 번호를 입력해주세요.", LottoInfo.MAX_SIZE.getNumberInfo()));

    private static final String ERROR = "[ERROR] %s";
    private final String message;

    ExceptionMessage(final String errorMessage) {
        this.message = String.format(ERROR, errorMessage);
    }

    public String getMessage() {
        return message;
    }
}
