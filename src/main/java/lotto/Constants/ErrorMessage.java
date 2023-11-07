package lotto.Constants;

public enum ErrorMessage {
    ERROR_HEAD("[ERROR] "),
    INPUT_DUPLICATED_NUMBER_MESSAGE("중복된 숫자는 입력할 수 없습니다."),
    INVALID_NUMBER_RANGE_MESSAGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_SIZE_MESSAGE("로또 번호는 6개여야 합니다."),
    INVALID_NUMBER_MESSAGE("반드시 숫자로만 입력해야 합니다."),
    INPUT_BLANK_MESSAGE("입력은 공백일 수 없습니다."),
    INPUT_EMPTY_MESSGAE("값을 입력하지 않았습니다."),
    INPUT_DUPLIDATED_BOUNS_MESSAGE("보너스 값은 입력된 6자리 값과 중복될 수 없습니다."),
    INVALID_MONEY_UNIT_MESSAGE("돈은 천원 단위로 투입 가능합니다."),
    INVALID_COMMA_POSITION_MESSAGE(",(comma) 는 맨 앞 혹은 맨 뒤에 올 수 없어요.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_HEAD.message + message;
    }
}
