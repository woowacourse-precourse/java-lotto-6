package lotto.message;

public enum OutputMessage {

    OUTPUT_BUY_MESSAGE("개를 구매했습니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

}
