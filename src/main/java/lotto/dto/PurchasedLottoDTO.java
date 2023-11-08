package lotto.dto;

import java.util.List;
import lotto.Lotto;

public class PurchasedLottoDTO {
    private final List<Lotto> purchasedLotto;

    public PurchasedLottoDTO(List<Lotto> purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }
}
