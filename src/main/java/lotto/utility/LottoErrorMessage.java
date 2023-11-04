package lotto.utility;

public enum LottoErrorMessage {
    WRONG_SIZE_ERROR("[ERROR] 당첨 번호는 총 6개의 숫자를 입력해야 합니다."),
    NOT_NUMBER_ERROR("[ERROR] 당첨 번호는 숫자만 입력해야 합니다."),
    DUPLICATE_ERROR("[ERROR] 당첨 번호를 중복해서 입력할 수 없습니다."),
    OUT_RANGE_ERROR("[ERROR] 당첨 번호는 1부터 45까지만 입력할 수 있습니다.");

    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
