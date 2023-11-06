package lotto.enums;

public enum ErrorMessage {
    INVALID_AMOUNT_ERROR("[ERROR] 올바른 금액을 입력해주세요."),
    INVALID_WINNING_NUMBERS_ERROR("[ERROR] 올바른 당첨 번호를 입력해주세요."),
    INVALID_LOTTO_NUMBERS_COUNT_ERROR("[ERROR] 로또 번호의 개수는 보너스 번호 포함 6개여야 합니다."),
    INVALID_BONUS_NUMBER_ERROR("[ERROR] 올바른 보너스 번호를 입력해주세요.");

    private String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
