package lotto.Domain;

import java.util.List;
import lotto.Lotto;
import lotto.Validator.InputValidator;
import lotto.View.InputView;

public class Customer {
    List<Lotto> purchasedLotto;

    public void buyLotto(LottoStore lottoStore) {
        String lottoPurchaseAmount = InputView.inputLottoPurchaseAmount();
        this.purchasedLotto = lottoStore.generateLotto(lottoPurchaseAmount);
    }
}
