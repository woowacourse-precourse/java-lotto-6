package lotto.exception;

import lotto.domain.GameSetting;

public enum Message {
    BONUS_SIZE("하나의 숫자만 입력해 주세요"),
    NUMBER_EMPTY("공백을 입력할 수 없습니다."),
    NUMBER_RANGE(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.",
            GameSetting.START_NUMBER.getValue(), GameSetting.END_NUMBER.getValue())),
    NUMBER_SIZE(String.format("%d자리를 기입해 주세요.", GameSetting.TICKET_SIZE.getValue())),
    NUMBER_UNIQUE("중복되는 숫자가 존재합니다."),
    NUMBER_TYPE("숫자만 입력해 주세요."),
    MONEY_RANGE("음수 또는 0이 입력될 수 없습니다."),
    MONEY_REMAINDER(String.format("%d 단위의 수를 입력해 주세요.", GameSetting.TICKET_PRICE.getValue()));

    private final String content;

    Message(String message) {
        this.content = "[ERROR] " + message;
    }

    public String getMessage() {
        return content;
    }
}
