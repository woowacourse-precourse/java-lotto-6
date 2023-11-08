package lotto.util;

public enum errorMessage {
    OUT_BOUND_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_ERROR("[ERROR] 리스트에 중복된 숫자가 있습니다."),
    DATA_TYPE_ERROR("[ERROR] 숫자 형식에 맞지 않습니다."),
    BUY_NOTHING_ERROR("[ERROR] 살 수 없는 금액입니다."),
    EXCESSIVE_NUMBER_ERROR("[ERROR] 너무 많은 갯수를 구입할 수 없습니다."),
    DIFFERENT_UNIT_ERROR("[ERROR] 천 단위로 입력해 주세요."),
    LOTTO_SIZE_ERROR("[ERROR] ','를 구분자로 6개의 숫자를 입력해 주세요.");

    private String message;

    errorMessage(String rank){
        this.message = rank;
    }

    public String getMessage() {
        return message;
    }
}
