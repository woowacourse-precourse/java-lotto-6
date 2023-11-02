package lotto.service;

import lotto.domain.PurchaseAmount;
import lotto.repository.DomainRepository;

public class LottoService {

    private final DomainRepository<PurchaseAmount> purchaseAmountRepository;

    public LottoService(final DomainRepository<PurchaseAmount> purchaseAmountRepository) {
        this.purchaseAmountRepository = purchaseAmountRepository;
    }

    public void savePurchaseAmount(final PurchaseAmount purchaseAmount) {
        purchaseAmountRepository.save(purchaseAmount);
    }
}
