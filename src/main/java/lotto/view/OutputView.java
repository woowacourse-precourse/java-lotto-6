package lotto.view;

import lotto.service.dto.PurchaseResultDto;

public class OutputView {
    private static final String purchaseComplete = "개를 구매했습니다.";

    public void notifyPurchaseResult(PurchaseResultDto purchaseResultDto) {
        System.out.println( purchaseResultDto.size()+ purchaseComplete);
        purchaseResultDto.lottoNumbers().forEach(System.out::println);
    }
}
