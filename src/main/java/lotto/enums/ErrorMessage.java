package lotto.enums;

public enum ErrorMessage {
    NOT_NULL("아무런 값을 입력하지 않았습니다."),
    NOT_ZERO("구입가격은 0을 입력할 수 없습니다."),
    NOT_START_ZERO("구입가격을 0으로 시작할 수 없습니다."),
    NOT_DIVIDE("1000원 단위의 수를 입력해야 합니다."),
    ONLY_NUMBER("숫자만 입력할 수 있습니다."),
    NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ONLY_COMMA("쉼표로 구분하여 입력해야 합니다."),
    LOTTO_NUMBER_SIZE("로또 번호는 6개의 번호로 이뤄져야 합니다."),
    BONUS_NUMBER_SIZE("보너스 번호는 1개의 번호로 이뤄줘야 합니다."),
    NUMBER_DUPLICATION("중복된 번호를 입력할 수 없습니다."),
    EXIST_IN_WINNING_NUMBER("이미 당첨번호에 존재하는 번호 입니다."),
    NOT_CONTAINS_BLANK("숫자를 공백으로 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
