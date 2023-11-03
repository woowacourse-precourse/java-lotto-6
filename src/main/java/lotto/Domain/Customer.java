package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.Validator.InputValidator;
import lotto.View.InputView;
import lotto.View.OutView;

public class Customer {
    private List<Lotto> purchasedLottos;
    private int lottoQuantity;

    public List<Lotto> buyLotto(LottoStore lottoStore, String lottoPurchaseAmount) {
        this.purchasedLottos = lottoStore.generateLotto(lottoPurchaseAmount);
        this.lottoQuantity = Integer.parseInt(lottoPurchaseAmount) / 1000;
        return this.purchasedLottos;
    }

    public int getLottoQuantity() {
        return this.lottoQuantity;
    }

    public List<String> getPurchasedLottoNumbers() {
        List<String> purchasedLottoNumbers = new ArrayList<>();
        for (Lotto lotto : this.purchasedLottos) {
            purchasedLottoNumbers.add(lotto.getNumbers());
        }
        return purchasedLottoNumbers;
    }
}
