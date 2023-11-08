package lotto.exception;

public class LottoExceptionMessages extends CommonExceptionMessages {
    public static final String EXPECTED_VALID_LENGTH =
            PREFIX_OF_ERROR_MESSAGE + "6개의 숫자를 입력해야 합니다.";
    public static final String EXPECTED_VALID_RANGE = PREFIX_OF_ERROR_MESSAGE + "최소 1에서 최대 45 사이의 숫자를 입력해야 합니다.";

    public static final String EXPECTED_NO_DUPLICATE = PREFIX_OF_ERROR_MESSAGE + "숫자는 중복되어서는 안됩니다.";
}
