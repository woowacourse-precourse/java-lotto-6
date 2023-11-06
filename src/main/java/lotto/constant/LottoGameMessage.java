package lotto.constant;

public enum LottoGameMessage {
    NUMBER_OF_LOTTO_MESSAGE("%d개를 구매했습니다.");

    private String message;

    private LottoGameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
