package lotto.config;

public enum LottoGameMessage {
    INPUT_GET_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ;

    private String message;

    LottoGameMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
