package lotto;

import static lotto.NumberConstants.*;

public enum Error {
    NON_NUMBER("숫자 외에 입력할 수 없습니다. 숫자만 입력해주세요."),
    NON_NUMBER_COMMA("숫자 또는 콤마(,) 외에 입력할 수 없습니다. 숫자 또는 콤마(,)만 입력해주세요."),
    CONTINUAL_COMMA("콤마(,)를 연속해서 입력할 수 없습니다. 한 개씩만 입력해주세요."),
    COMMA_EDGE("양끝에 콤마(,)를 입력할 수 없습니다. 양끝에는 숫자를 입력해주세요."),
    NOT_PLUS_SIGN("0 또는 음수를 입력할 수 없습니다. 양수를 입력해주세요."),
    NOT_IN_RANGE(String.format("로또 번호 범위 외의 수를 포함할 수 없습니다. %d이상 %d이하의 수만 입력해주세요.", MIN_NUMBER, MAX_NUMBER)),
    DUPLICATES("로또/보너스 번호는 서로 중복될 수 없습니다. 서로 중복되지 않게 입력해주세요."),
    WRONG_SIZE(String.format("로또 번호의 개수가 %d개가 아닙니다. %d개의 번호를 입력해주세요.", LOTTO_SIZE, LOTTO_SIZE));


    private static final String ERROR = "[ERROR] ";
    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + this.message;
    }
}
