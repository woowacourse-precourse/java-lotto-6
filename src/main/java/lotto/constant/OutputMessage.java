package lotto.constant;

public enum OutputMessage {
    OUTPUT_PURCHASE_AMOUNT_MESSAGE("%d개를 구매했습니다.");

    private final String template;

    OutputMessage(String template) {
        this.template = template;
    }

    public String getMessage(int count) {
        return String.format(template, count);
    }
}
