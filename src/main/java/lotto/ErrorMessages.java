package lotto;

import static lotto.config.RuleConfig.BASE_LOTTO_PRICE;

public enum ErrorMessages {
    NOT_INTEGER("숫자가 아닌 값이 있습니다. 숫자를 입력 해주세요."),
    NO_MONEY("0보다 큰 수가 필요합니다."),
    TOO_MANY_LOTTOS("최대 구매 가능 개수를 초과했습니다."),
    UNIT_BASE_PRICE(String.format("%d원 단위로만 구매가 가능합니다.", BASE_LOTTO_PRICE)),
    OUT_OF_RANGE("Min, Max 값 사이여야 합니다."),
    DUPLICATE("중복된 숫자가 있습니다."),
    ALREADY_HAVE("보너스 번호가 이미 당첨 번호에 포함되어 있습니다."),
    INVALID_LOTTO_LENGTH("로또 번호 갯수가 맞지 않습니다.")
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
