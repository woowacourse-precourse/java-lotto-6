package lotto.view;

import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.PurchaseLottoDto;

public class OutputView {
    private static final String PURCHASE_LOTTO_FORM_DELIMITER = " \n";

    private String makePurchaseLottoResultForm(PurchaseLottoDto purchaseLottoDto) {
        List<String> purchaseLottoResults = purchaseLottoDto.getTotalPurchaseLotto()
                .stream()
                .map(LottoDto::toString)
                .toList();

        return String.join(PURCHASE_LOTTO_FORM_DELIMITER, purchaseLottoResults);
    }
}
