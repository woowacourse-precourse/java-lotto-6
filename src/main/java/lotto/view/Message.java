package lotto.view;

public enum Message {
    FOR_BUY_AMOUNT("구입금액을 입력해 주세요. ");

    private final String label;

    Message(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }

}