package lotto.domain;

import lotto.exception.ErrorCode;

import java.util.List;

public class PurchaseLottos {

    private final List<Lotto> purchaseLottos;

    public PurchaseLottos(List<Lotto> purchaseLottos) {
        validatorSize(purchaseLottos);
        this.purchaseLottos = purchaseLottos;
    }

    private void validatorSize(List<Lotto> purchaseLottos) {
        if (purchaseLottos.isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.NOT_FOUND_PURCHASE_LOTTO.getMessage());
        }
    }

    public List<Lotto> getPurchaseLottos() {
        return purchaseLottos;
    }
}
