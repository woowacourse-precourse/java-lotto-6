package lotto.constants;

import static java.lang.String.format;

public enum ExceptionMessage {
    DELIM_START_END_ERROR("쉼표가 맨앞 혹은 맨뒤에 쓰였습니다."),
    DELIM_CONSECUTIVE_ERROR("쉼표가 중복으로 쓰였습니다."),
    WHITESPACE_ERROR("공백이 포함되어 있습니다."),
    PAY_RANGE_ERROR(format("구입 비용은 %d원 이상이며 그 배수여야 합니다.", GameRule.PAY_UNIT)),
    LOTTO_RANGE_ERROR(format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.",GameRule.MIN_LOTTO_NUMBER,GameRule.MAX_LOTTO_NUMBER)),
    LOTTO_LENGTH_ERROR(format("로또 번호는 %d개여야 합니다.", GameRule.LOTTO_LENGTH)),
    BONUS_DUPLICATE_ERROR("보너스 번호는 로또 번호와 중복되면 안 됩니다."),
    LOTTO_DUPLICATE_ERROR("로또 번호는 중복되면 안 됩니다."),
    NOT_INTEGER_ERROR("입력값은 정수형이어야합니다."),
    NEGATIVE_NUMBER_ERROR("입력값은 양수여야합니다.");

    private static final String ERROR = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }
}
