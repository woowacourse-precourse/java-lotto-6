package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;

public class LottoController {

    public List<Lotto> buyLottery(String stringPurchasePrice) {
        Integer purchasePrice = validatePurchasePrice(stringPurchasePrice);

        LottoService lottoService = new LottoService();
        return lottoService.buyLottery(purchasePrice);
    }

    private Integer validatePurchasePrice(String stringPurchasePrice) {
        validatePurchasePriceType(stringPurchasePrice);
        Integer purchasePrice = Integer.valueOf(stringPurchasePrice);
        validatePurchasePriceRange(purchasePrice);
        return purchasePrice;
    }

    private void validatePurchasePriceRange(Integer purchasePrice) {
        if (purchasePrice % 1_000 != 0) {
            throw new IllegalArgumentException("로또는 1000원 단위로만 구매할 수 있습니다.");
        }
    }

    private void validatePurchasePriceType(String purchasePrice) {
        try {
            Integer.valueOf(purchasePrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 금액은 숫자만 입력 가능합니다.");
        }
    }
}
