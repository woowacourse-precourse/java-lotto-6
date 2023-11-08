package lotto.constant;

import static lotto.constant.LottoConstant.LOTTO_LENGTH;

public class ExceptionMessage {

    public static final String ERROR_FORMAT_MESSAGE = "[ERROR] ";
    public static final String NO_DUPLICATE_WINNING_NUMBER_ERROR_MESSAGE =
            ERROR_FORMAT_MESSAGE + "당첨 번호와 중복된 보너스 번호는 입력할 수 없습니다.";
    public static final String NO_DUPLICATE_ERROR_MESSAGE =
            ERROR_FORMAT_MESSAGE + "중복된 숫자는 입력할 수 없습니다.";
    public static final String OUT_OF_RANGE_ERROR_MESSAGE =
            ERROR_FORMAT_MESSAGE + "1 ~ 45 사이의 숫자만 입력할 수 있습니다.";
    public static final String DIVISION_ERROR_MESSAGE =
            ERROR_FORMAT_MESSAGE + "1000원으로 나눌 수 있는 금액만 입력 가능합니다.";
    public static final String NO_EMPTY_ERROR_MESSAGE =
            ERROR_FORMAT_MESSAGE + "공백 혹은 빈문자는 입력할 수 없습니다.";
    public static final String ONLY_NUMBER_MESSAGE = ERROR_FORMAT_MESSAGE + "숫자만 입력할 수 있습니다.";
    public static final String LOTTO_LENGTH_ERROR_MESSAGE =
            ERROR_FORMAT_MESSAGE + LOTTO_LENGTH + "자리만 입력할 수 있습니다.";
    public static final String UNIT_PRICE_ERROR_MESSAGE =
            ERROR_FORMAT_MESSAGE + "1000원 단위로 입력 가능합니다.";

    private ExceptionMessage() {
    }
}
