package lotto;

public enum ErrorMessages {
    NOT_INTEGER("숫자 입력을 해주세요."),
    NO_MONEY("0보다 큰 수가 필요합니다."),
    TOO_MANY_LOTTOS("최대 구매 가능 개수를 초과했습니다."),
    UNIT_BASE_PRICE("1000원 단위로만 구매가 가능합니다.")

    ;
    private final String message;

    ErrorMessages(String message){
        this.message = message;
    }
    @Override
    public String toString() {
        return this.message;
    }
}
