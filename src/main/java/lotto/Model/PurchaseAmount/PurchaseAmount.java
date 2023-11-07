package lotto.Model.PurchaseAmount;

import static lotto.Common.LottoValue.*;

public class PurchaseAmount {
    private final Integer Amount;

    public PurchaseAmount(Integer amount) {

        this.Amount = amount;
    }

    /**
     * 유저가 입력한 금액 에 대하 모델에서 검증할 목록
     * 1이상의 정수 일것
     * 1000원 단위 일것
     */

    private void validateInteger( Integer amount ) {
        if( amount <= 0) {
            throw new IllegalArgumentException("");
        }

    }

    private void validateThousandUnit( Integer amount) {
        if( amount <= LOTTO_ONE_TICKET_PRICE.getValue() && amount % LOTTO_ONE_TICKET_PRICE.getValue() != 0 ) {
            throw new IllegalArgumentException("");
        }
    }

}
