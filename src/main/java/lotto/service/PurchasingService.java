package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Lotto;

public class PurchasingService {

    private static final int LOTTO_PRICE = 1000;

    private Buyer buyer;
    private int buyerPurchaseQuantity;
    private List<Lotto> buyerLotto = new ArrayList<>();

    public Buyer purchaseLotto(int amount) {
        checkAmount(amount);
        calculateLottoQuantity(amount);
        issueLotto();
        giveLottoToBuyer(amount);
        return buyer;
    }

    private void checkAmount(int amount) {
        validateMinPurchase(amount);
        validatePurchaseUnits(amount);
    }

    private void validateMinPurchase(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또를 한 장 이상 구매해야 합니다. (로또 1장 1,000원");
        }
    }

    private void validatePurchaseUnits(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로 구매 가능합니다. (로또 1장 1,000원");
        }
    }

    private void calculateLottoQuantity(int amount) {
        buyerPurchaseQuantity = amount / LOTTO_PRICE;
    }

    private void issueLotto() {
        LottoService lottoService = new LottoService();
        for (int i = 0; i < buyerPurchaseQuantity; i++) {
            buyerLotto.add(lottoService.createLotto());
        }
    }

    private void giveLottoToBuyer(int amount) {
        buyer = new Buyer(amount, buyerLotto);
    }
}
