package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.view.ErrorMessage;

public class PurchasingService {

    private static final int LOTTO_PRICE = 1000;
    private static final int NONE = 0;
    private static final int ZERO = 0;

    private Buyer buyer;
    private int buyerPurchaseQuantity;
    private List<Lotto> buyerLottoTickets = new ArrayList<>();

    public Buyer purchaseLotto(String value) {
        int amount = checkAmount(value);
        calculateLottoQuantity(amount);
        issueLotto();
        giveLottoToBuyer(amount);
        return buyer;
    }

    public int getBuyerPurchaseQuantity() {
        return buyerPurchaseQuantity;
    }

    private int checkAmount(String value) {
        validateEmpty(value);
        validateOnlyNumber(value);
        int amount = Integer.parseInt(value);
        validateMinPurchase(amount);
        validatePurchaseUnits(amount);
        return amount;
    }

    private void validateEmpty(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY);
        }
    }

    private void validateOnlyNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER);
        }
    }

    private void validateMinPurchase(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_MIN);
        }
    }

    private void validatePurchaseUnits(int amount) {
        if (amount % LOTTO_PRICE != NONE) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_UNITS);
        }
    }

    private void calculateLottoQuantity(int amount) {
        buyerPurchaseQuantity = amount / LOTTO_PRICE;
    }

    private void issueLotto() {
        LottoGeneratorService lottoGeneratorService = new LottoGeneratorService();
        for (int i = ZERO; i < buyerPurchaseQuantity; i++) {
            buyerLottoTickets.add(lottoGeneratorService.createLotto());
        }
    }

    private void giveLottoToBuyer(int amount) {
        buyer = new Buyer(amount, buyerPurchaseQuantity, buyerLottoTickets);
    }
}
