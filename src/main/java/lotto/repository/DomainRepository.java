package lotto.repository;

import lotto.constant.ErrorMessage;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;

import java.util.Optional;
import java.util.function.Supplier;

public class DomainRepository {

    private PurchaseAmount purchaseAmount;
    private Lottos lottos;

    public void saveLottos(final Lottos lottos) {
        this.lottos = lottos;
    }

    public Lottos getLottos() {
        return get(() -> this.lottos);
    }

    public void savePurchaseAmount(final PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public PurchaseAmount getPurchaseAmount() {
        return get(() -> this.purchaseAmount);
    }

    private <T> T get(final Supplier<T> supplier) {
        return Optional.ofNullable(supplier.get())
                .orElseThrow(
                        () -> new IllegalStateException(ErrorMessage.NOT_INITIALIZED.toValue()));
    }
}
