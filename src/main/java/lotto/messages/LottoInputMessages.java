package lotto.messages;

public enum LottoInputMessages {
    INPUT_USER_LOTTO_PURCHASE("구입금액을 입력해 주세요."),
    INPUT_USER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_USER_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    COMPLETE_MESSAGE_LOTTO_COST("%d개를 구매했습니다.\n");

    private final String message;

    LottoInputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
