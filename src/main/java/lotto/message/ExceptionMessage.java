package lotto.message;

public enum ExceptionMessage {
    ONLY_NUMBER("[ERROR] 숫자만 입력해야 합니다."),
    LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE("[ERROR] 로또 번호는 중복된 숫자가 없어야 합니다."),
    OUT_OF_RANGE("[ERROR] 로또 번호는 1에서 45 사이여야 합니다."),
    PURCHASE_AMOUNT("[ERROR] 구매 금액은 1000의 배수여야 합니다."),
    BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호에 없는 번호여야 합니다.")
    ;

    private String message;

    private ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
