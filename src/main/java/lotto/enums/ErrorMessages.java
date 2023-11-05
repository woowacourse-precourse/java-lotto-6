package lotto.enums;

public enum ErrorMessages {

    INPUT_EMPTY_EXCEPTION_MSG("[ERROR] 입력은 비어있을 수 없습니다."),
    INPUT_BLANK_EXCEPTION_MSG("[ERROR] 입력은 공백일 수 없습니다."),
    NON_NUMBER_EXCEPTION_MSG("[ERROR] 숫자가 아닌 다른 값은 입력할 수 없습니다."),
    INPUT_DIVIDE_EXCEPTION_MSG("[ERROR] 로또 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다."),
    NUMBER_RANGE_EXCEPTION_MSG("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ANSWER_FORM_EXCEPTION_MSG("[ERROR] 당첨 번호는 (,)으로 구분된 6자리의 숫자여야 합니다."),
    ANSWER_AMOUNT_EXCEPTION_MSG("[ERROR] 주어진 숫자가 많거나 모자릅니다. 6자리의 숫자를 입력해야 합니다."),
    ANSWER_DUPLICATED_EXCEPTION_MSG("[ERROR] 로또 번호에는 중복된 숫자가 존재할 수 없습니다."),
    BONUS_NUMER_CONFLICT_EXCEPTION_MSG("[ERROR] 당첨 번호에 입력한 숫자는 입력할 수 없습니다.");

    private final String msg;

    ErrorMessages(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
