package lotto.service;

import lotto.constants.AppConstants;
import lotto.constants.ErrorConstants;
import lotto.domain.LottoTicket;
import lotto.utils.StringUtil;

public class LottoPurchaseService {

    private int LOTTO_TICKET_PRICE = Integer.parseInt(AppConstants.LOTTO_TICKET_PRICE.getData());

    public LottoTicket purchaseLottoTicket(String purchaseAmount) {
        // 사용자로부터 입력된 금액으로 로또 티켓을 구매하고 LottoTicket 객체를 반환
        validatePurchaseAmount(purchaseAmount);
        return new LottoTicket(Integer.parseInt(purchaseAmount));
    }
    private void validatePurchaseAmount(String purchaseAmount) {
        // 구매 금액 검증
        StringUtil.checkNotNull(purchaseAmount);
        StringUtil.checkNumeric(purchaseAmount);

    }








}