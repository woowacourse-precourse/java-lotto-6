package lotto.domain.constant;

public enum CommonMessage {

    DUPLICATE_ERROR_MESSAGE("중복된 번호가 있습니다."),
    SIZE_ERROR_MESSAGE("잘못된 개수의 번호입니다."),
    RANGE_ERROR_MESSAGE("잘못된 범위의 번호입니다."),
    INPUT_ERROR_MESSAGE("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.");

    private final String message;

    CommonMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }
}
