package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.LottoNumber;
import lotto.constant.LottoPrice;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.MessageService;
import lotto.service.ValidateService;

public class LottoPurchase {
    private final InputService inputService = new InputService();
    private final MessageService messageService = new MessageService();
    private final ValidateService validateService = new ValidateService();
    private final LottoService lottoService = new LottoService();

    private List<Lotto> purchaseLotto = new ArrayList<>();
    private int purchasePrice;

    public int inputPurchasePrice() {
        messageService.inputPurchasePrice();
        while (true) {
            try {
                purchasePrice = validateService.validateNumber(inputService.inputValue());
                validateService.validatePurchasePriceAll(purchasePrice);
                return purchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getPurchaseAmount() {
        return inputPurchasePrice() / LottoNumber.LOTTO_PRICE.getNumber();
    }

    public List<Lotto> purchaseLottoNumbers(int purchaseAmount) {
        for (int i = 0; i < purchaseAmount; i++) {
            purchaseLotto.add(generateLottoNumbers());
        }
        return purchaseLotto;
    }

    public Lotto generateLottoNumbers() {
        List<Integer> lottoNumbers = lottoService.generateLottoNumbers();
        messageService.outputPurchaseNumbers(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
