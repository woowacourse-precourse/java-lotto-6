package lotto.exception;

public enum ExceptionMessage {
    INVALID_PURCHASE_PRICE("[ERROR] 로또 구입 금액은 1,000원 단위로 입력이 가능합니다."),
    INVALID_SIZE_LOTTO_NUMBER("[ERROR] 로또 번호의 개수는 6개만 가능합니다."),
    INVALID_RANGE_LOTTO_NUMBER("[ERROR] 로또 번호는 1~45까지 숫자만 가능합니다."),
    DUPLICATION_LOTTO_NUMBER("[ERROR] 중복된 로또 번호는 사용할 수 없습니다.")
    ;
    private String desc;

    ExceptionMessage(String description) {
        this.desc = description;
    }

    public String getDesc(){
        return this.desc;
    }

}
