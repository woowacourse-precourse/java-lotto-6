package view;

public enum OutputMessage {
    OUTPUT_ERROR_PRICE_THOUSAND("로또 구입 금액은 1,000원 단위로 입력해야 합니다."),
    OUTPUT_ERROR_PRICE_ZERO("로또 구입 금액은 0보다 커야 합니다."),
    OUTPUT_ERROR_PRICE_NUMBER("로또 구입 금액은 숫자로만 입력해야 합니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
