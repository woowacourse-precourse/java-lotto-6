package lotto.template;

import lotto.domain.PurchaseLotto;
import lotto.view.InputView;

public class PurchaseLottoOperation implements Operation<PurchaseLotto> {

    @Override
    public PurchaseLotto execute() throws IllegalArgumentException {
        return new PurchaseLotto(InputView.PurchaseAmount());
    }
}
