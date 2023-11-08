package lotto.enums;

public enum ExceptionMessages {
    INVALID_AMOUNT_MESSAGE("[ERROR] 잘못 입력된 구입 금액입니다. (1000원 단위로 입력해 주세요.)"),
    INVALID_LOTTO_NUMBERS("[ERROR] 잘못 입력된 당첨 번호입니다. (,를 기준으로 중복되지 않는 1~45범위의 숫자 6개를 입력해주세요. ex. 1,10,15,20,25,30)"),
    INVALID_BONUS_NUMBER("[ERROR] 잘못 입력된 보너스 번호입니다. (1~45 범위의 숫자 1개를 입력해주세요.)");
    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
