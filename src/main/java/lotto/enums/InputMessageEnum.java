package lotto.enums;

public enum InputMessageEnum {

    INPUT_PURCHASE_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");

    private String message;

    InputMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
