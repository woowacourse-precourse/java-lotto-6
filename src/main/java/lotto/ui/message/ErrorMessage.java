package lotto.ui.message;

public enum ErrorMessage {

    LESS_THAN_THOUSAND("[ERROR] 금액은 1000원 이상만 입력 가능합니다."),
    NON_THOUSAND_UNIT("[ERROR] 금액은 1000원 단위로만 입력 가능합니다."),
    ;


    private final String comment;

    ErrorMessage(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return this.comment;
    }



}
