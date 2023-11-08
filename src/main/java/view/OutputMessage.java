package view;

public enum OutputMessage {
    OUTPUT_ERROR_PRICE_THOUSAND("로또 구입 금액은 1,000원 단위로 입력해야 합니다."),
    OUTPUT_ERROR_PRICE_ZERO("로또 구입 금액은 0보다 커야 합니다."),
    OUTPUT_ERROR_PRICE_VALID("로또 구입 금액은 숫자로만 입력해야 합니다."),
    OUTPUT_ERROR_LOTTO_COUNT("로또 번호의 개수는 6개 입니다."),
    OUTPUT_ERROR_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이여야 합니다."),
    OUTPUT_ERROR_LOTTO_NUMBER_VALID("로또 번호는 숫자여야 합니다."),
    OUTPUT_ERROR_LOTTO_NUMBER_UNIQUE("로또 번호는 중복 될 수 없습니다.");


    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
