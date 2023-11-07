package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumber;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.MessageService;

public class LottoPurchase {
    private final InputService inputService = new InputService();
    private final MessageService messageService = new MessageService();
    private final LottoService lottoService = new LottoService();

    private List<Lotto> purchaseLotto = new ArrayList<>();
    private int purchasePrice;

    public int inputPurchasePrice() {
        messageService.inputPurchasePrice();
        while (true) {
            try {
                purchasePrice = validateNumber(inputService.inputValue());
                validatePurchasePriceAll(purchasePrice);
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

    private void validatePurchasePriceAll(int purchasePrice) {
        validatePrice(purchasePrice);
        validateCheckDivisibility(purchasePrice);
    }

    private void validatePrice(int purchasePrice) {
        if (purchasePrice < LottoNumber.LOTTO_PRICE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_PRICE_MESSAGE.getMessage());
        }
    }

    private void validateCheckDivisibility(int purchasePrice) {
        if (purchasePrice % LottoNumber.LOTTO_PRICE.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.DIVISIBILITY_CHECK_AMOUNT.getMessage());
        }
    }

    private int validateNumber(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_ERROR.getMessage());
        }
    }
}
