package lotto.constants;

public enum ErrorMessages {
    ERR_AMOUNT_UNIT("[ERROR] 구입 금액은 1,000원 단위로 입력해 주세요."),
    ERR_INPUT_IS_NOT_NUM("[ERROR] 양의 정수(자연수)만 입력해주세요"),
    ERR_INPUT_LIST_SIZE("[ERROR] 6개의 숫자를 입력해주세요."),
    ERR_OUT_OF_BOUND("[ERROR] 1에서 45사이의 숫자를 입력하세요."),
    ERR_DUPLICATED_NUMBER("[ERROR] 중복된 숫자가 있습니다."),
    ERR_BONUS_CONTAIN_IN_MAGIC("[ERROR] 보너스 번호가 당첨 번호에 포함 되어 있습니다.");


    private String message;
    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
