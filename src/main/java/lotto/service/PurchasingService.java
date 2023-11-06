package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Lotto;

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
            throw new IllegalArgumentException("[ERROR] 입력 값이 없습니다.");
        }
    }

    private void validateOnlyNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void validateMinPurchase(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또를 한 장 이상 구매해야 합니다. (로또 1장 1,000원)");
        }
    }

    private void validatePurchaseUnits(int amount) {
        if (amount % LOTTO_PRICE != NONE) {
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로 구매 가능합니다. (로또 1장 1,000원)");
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

    public int getBuyerPurchaseQuantity() {
        return buyerPurchaseQuantity;
    }
}
