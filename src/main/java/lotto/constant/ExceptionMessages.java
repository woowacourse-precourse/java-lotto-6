package lotto.constant;

public enum ExceptionMessages {
    PURCHASE_AMOUNT_FORMAT_EXCEPTION_MESSAGE("구입금액은 양의 정수여야 합니다."),
    WINNING_NUMBER_FORMAT_EXCEPTION_MESSAGE("당첨 번호는 ,로 구분된 양의 정수의 배열이어야 합니다.");


    private String value;

    private ExceptionMessages(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
