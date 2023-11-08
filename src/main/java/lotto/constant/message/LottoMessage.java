package lotto.constant.message;

public enum LottoMessage {
    INPUT_MONEY("구입금액을 입력해 주세요.");

    LottoMessage(String text) {
        this.text = text;
    }

    private final String text;

    public String getText() {
        return text;
    }
}
