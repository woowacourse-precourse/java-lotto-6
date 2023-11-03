package lotto.domain;

import lotto.ui.message.ErrorMessage;

public class Money {

    private static final Integer LOTTO_PRICE = 1000;

    private final Integer amount;

    public Money(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    //TODO: 이 기능을 Money가 가지고 있는건 너무 많은 역할이라는 생각이 들어.
    public Integer issueLottoTicket() {
        return amount / LOTTO_PRICE;
    }

    private void validate(Integer amount) {
        if (amount < 1000) {
            //TODO: 도메인의 모든 에러메시지를 한 곳에 모아두는 것이 적절할까?
            // 오히려 더 구별이 힘들거 같아..
            throw new IllegalArgumentException(ErrorMessage.LESS_THAN_THOUSAND.getComment());
        }

        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NON_THOUSAND_UNIT.getComment());
        }
    }
}
