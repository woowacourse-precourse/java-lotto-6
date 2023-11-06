package lotto.util.constants;

public enum OutputConstants {
    LOTTO_COUNT_MESSAGE("개를 구매했습니다.");

    private final String string;

    OutputConstants(String inputMessage) {
        this.string = inputMessage;
    }

    public String getOutputMessage() {
        return string;
    }
}
