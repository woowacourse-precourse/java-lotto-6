package lotto;

import lotto.domain.LottoPurchaseAmount;
import lotto.domain.LottoTickets;
import lotto.ui.InputUI;
import lotto.util.LottoGenerator;

/**
 * @author 민경수
 * @description lotto store
 * @since 2023.11.04
 **********************************************************************************************************************/
public class LottoStore {

    private final InputUI inputUI;

    public LottoStore(InputUI inputUI) {
        this.inputUI = inputUI;
    }

    public LottoTickets buyLotto() {
        LottoPurchaseAmount lottoPurchaseAmount = LottoPurchaseAmount.valueOf(inputUI.getAmount());
        return getLotto(lottoPurchaseAmount);

    }

    private LottoTickets getLotto(LottoPurchaseAmount lottoPurchaseAmount) {
        return getLottosWithManualNumbers(lottoPurchaseAmount);
    }

    private LottoTickets getLottosWithManualNumbers(LottoPurchaseAmount lottoPurchaseAmount) {
        LottoTickets purchasedLottos = LottoGenerator.buyLottos(lottoPurchaseAmount);
        return purchasedLottos;
    }
}