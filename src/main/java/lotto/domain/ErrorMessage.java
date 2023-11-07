package lotto.domain;

public enum ErrorMessage {

    NO_PARSE_TO_NUMBER("[ERROR] 숫자를 입력해야 합니다. 다시 입력하여 주세요"),
    NOT_MULTIPLE_OF_THOUSAND("[ERROR] 1000원 단위로 다시 입력하여 주세요 입력 값 = "),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 이미 로또 번호에 있는 번호 입니다. 다시 입력하여 주세요"),
    OUT_OF_RANGE_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다. 다시 입력하여 주세요"),
    NO_COUNT_LOTTO_NUMBERS("[ERROR] 당첨 번호가 6개가 아닙니다. 다시 입력하여 주세요");

    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
