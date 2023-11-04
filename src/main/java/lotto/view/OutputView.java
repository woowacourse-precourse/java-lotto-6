package lotto.view;


import lotto.domain.dto.PurchaseAmountDto;

public class OutputView {
    public static final String LOTTO_PURCHASE_RESULT_MESSAGE = "%d개를 구매했습니다.";

    public void printPurchaseQuantityLottos(final PurchaseAmountDto purchaseAmountDto) {
        System.out.printf(LOTTO_PURCHASE_RESULT_MESSAGE, purchaseAmountDto.purchaseQuantityLottos());
    }
}
