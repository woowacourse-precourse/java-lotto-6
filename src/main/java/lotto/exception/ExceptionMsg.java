package lotto.exception;

public enum ExceptionMsg {
    NULL_INPUT("아무런 입력이 없습니다.\n"),
    NOT_INT_TRY("입력이 숫자가 아닙니다.\n"),
    NOT_MULTIPLE_THOUSAND("구입금액이 1000의 배수가 아닙니다\n"),
    DUPLICATE_LOTTO_NUM("로또 번호가 중복될 수 없습니다.\n");

    private final String message;

    ExceptionMsg(String message) {
        this.message = message;
    }
}
