package lotto.constant;

public enum LottoNumberMessage {
    ASK_Lotto_NUMBER("당첨 번호를 입력해주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해주세요.");

    private final String message;

    LottoNumberMessage(String message) {
        this.message = message;

    }

    public String getMessage() {
        return message;
    }
}






