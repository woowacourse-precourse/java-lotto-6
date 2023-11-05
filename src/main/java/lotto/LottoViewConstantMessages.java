package lotto;

public enum LottoViewConstantMessages {
    PURCHASE_PRICE_REQUEST_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASED_QUANTITY_MESSAGE("개를 구매했습니다."),
    WINNING_NUMBERS_REQUEST_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_REQUEST_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String message;

    LottoViewConstantMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
