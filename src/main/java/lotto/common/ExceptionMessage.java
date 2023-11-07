package lotto.common;

import static lotto.common.Constant.MAX_RANGE;
import static lotto.common.Constant.MIN_RANGE;

public final class ExceptionMessage {
    public static final String INPUT_BLANK_ERROR = "[ERROR] 값이 공백 입니다.";
    public static final String INPUT_INVALID_INTEGER_ERROR = "[ERROR] 값이 유효한 정수가 아닙니다.";
    public static final String INPUT_NOT_MULTIPLE_OF_THOUSAND_ERROR = "[ERROR] 값이 1000 단위의 정수가 아닙니다.";
    public static final String NUMBER_NOT_IN_RANGE_ERROR = String.format("[ERROR] 값이 %d에서 %d 사이의 정수가 아닙니다.",
            MIN_RANGE, MAX_RANGE);
    public static final String MAIN_NUMBERS_SIZE_ERROR = "[ERROR] 당첨 번호가 6개가 아닙니다.";
    public static final String MAIN_NUMBERS_DUPLICATE_ERROR = "[ERROR] 당첨 번호가 중복됩니다.";
}
