package view;

public enum OutputMessage {
    OUTPUT_ERROR_PRICE("로또 구입 금액은 1,000원 단위로 입력해야 합니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
