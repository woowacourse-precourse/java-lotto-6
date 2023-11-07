package lotto.global.common;

public enum ErrorMessage {
    ONLY_NUMBER("[ERROR] 숫자만 입력해 주세요."),
    ONE_WORD_AND_OVER("[ERROR] 한 글자 이상 입력해 주세요."),
    MULTIPLE_OF_1000("[ERROR] 구매금액은 1,000원 단위로 입력해 주세요."),
    RANGE_1_45("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다."),
    HUNDRED_THOUSAND_OR_UNDER("[ERROR] 10만원 이하로 구입할 수 있습니다."),
    SIX_NUMBERS("[ERROR] 6개의 숫자만 입력해 주세요."),
    DUPLICATE("[ERROR] 로또 번호는 중복이 없어야 합니다."),
    DUPLICATE_BONUS("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private String message;

    private ErrorMessage(){}

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
