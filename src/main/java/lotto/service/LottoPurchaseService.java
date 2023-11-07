package lotto.service;

import lotto.domain.LottoTicket;

public class LottoPurchaseService {
    public LottoTicket purchaseLottoTicket(String purchaseAmount) {
        // 사용자로부터 입력된 금액으로 로또 티켓을 구매하고 LottoTicket 객체를 반환
        validatePurchaseAmount(purchaseAmount);
        return new LottoTicket(Integer.parseInt(purchaseAmount));
    }
    private void validatePurchaseAmount(String purchaseAmount) {
        // todo 구매 금액 검증
    }


}