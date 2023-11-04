package lotto.service;

import lotto.model.LottoTicket;
import lotto.model.PurchaseAmount;
import lotto.util.RandomNumberGenerator;

public class LottoService {
    private PurchaseAmount purchaseAmount;
    private LottoTicket lottoTicket;

    public void initPurchaseAmount(String inputMoney) {
        this.purchaseAmount = new PurchaseAmount(inputMoney);
    }
    
    public void purchaseLotto() {
        for (int i = 0; i < purchaseAmount.getMaxLottoCountForBudget(); i++) {
            lottoTicket.addLotto(RandomNumberGenerator.createUniqueNumbers());
        }
    }

}
