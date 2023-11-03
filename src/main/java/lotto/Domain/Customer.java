package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class Customer {
    private List<Lotto> purchasedLottos;

    public List<Lotto> buyLotto(LottoStore lottoStore, String lottoPurchaseAmount) {
        this.purchasedLottos = lottoStore.generateLotto(lottoPurchaseAmount);
        return this.purchasedLottos;
    }

    public List<String> getPurchasedLottoNumbers() {
        List<String> purchasedLottoNumbers = new ArrayList<>();
        for (Lotto lotto : this.purchasedLottos) {
            purchasedLottoNumbers.add(lotto.getNumbers());
        }
        return purchasedLottoNumbers;
    }
}
