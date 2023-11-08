package lotto.utils;

public enum Message {
    NUMBER_RANGE_ERROR("[ERROR] 숫자는 1에서 45 사이어야 합니다."),
    DUPLICATION_LIST_ERROR("[ERROR] 숫자는 1에서 45 사이어야 합니다."),
    LENGTH_ERROR("[ERROR] 당첨 번호의 개수를 만족시키지 못합니다."),
    NOT_ENOUGH_PRICE_ERROR("[ERROR] 1000원 이상으로 입력해야 합니다."),
    MULTIPLE_PRICE_ERROR("[ERROR] 입력은 1000원 단위여야 합니다."),
    INPUT_INTERGER_ERROR("[ERROR] 숫자가 아닌 값이 포함되어 있습니다."),
    DUPLICATION_BONUS_ERROR("[ERROR] 당첨 번호와 중복입니다.");
    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
