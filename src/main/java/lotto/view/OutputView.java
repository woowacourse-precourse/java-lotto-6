package lotto.view;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.PurchaseLottoDto;

public class OutputView {
    private static final String PURCHASED_MESSAGE = "%d개를 구매했습니다.%n";
    private static final String PURCHASE_LOTTO_FORM_DELIMITER = " \n";

    public void printPurchaseLotto(PurchaseLottoDto purchaseLottoDto) {
        System.out.printf(PURCHASED_MESSAGE, purchaseLottoDto.size());
        String purchaseLottoResultForm = makePurchaseLottoResultForm(purchaseLottoDto);
        System.out.println(purchaseLottoResultForm);
    }

    private String makePurchaseLottoResultForm(PurchaseLottoDto purchaseLottoDto) {
        List<String> purchaseLottoResults = purchaseLottoDto.getTotalPurchaseLotto()
                .stream()
                .map(LottoDto::toString)
                .toList();

        return String.join(PURCHASE_LOTTO_FORM_DELIMITER, purchaseLottoResults);
    }
}
