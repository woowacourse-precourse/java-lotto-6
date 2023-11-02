package lotto.domain;

import java.util.List;
import lotto.service.InputService;
import lotto.service.ValidateService;

public class LottoPurchase {
    private final InputService inputService = new InputService();
    private final ValidateService validateService = new ValidateService();
    private int purchaseAmount;
    private int purchasePrice;
    private List<Integer> lottoNumbers;

    public int getPurchasePrice() {
        purchasePrice = validateService.validateNumber(inputService.inputValue());
        validateService.validateAll(purchasePrice);
        return purchasePrice;
    }
}
