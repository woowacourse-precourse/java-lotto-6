package lotto;

import lotto.domain.LottoPurchaseAmount;
import lotto.domain.LottoTickets;
import lotto.ui.InputUI;
import lotto.ui.ResultUI;
import lotto.util.LottoGenerator;

/**
 * @author 민경수
 * @description lotto store
 * @since 2023.11.04
 **********************************************************************************************************************/
public class LottoStore {

    private final InputUI inputUI;
    private final ResultUI resultUI;

    public LottoStore(InputUI inputUI, ResultUI resultUI) {
        this.inputUI = inputUI;
        this.resultUI = resultUI;
    }

    public LottoTickets buyLotto() {
        while (true) {
            try {
                return getLottos(LottoPurchaseAmount.valueOf(inputUI.getAmount()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoTickets getLottos(LottoPurchaseAmount lottoPurchaseAmount) {
        LottoTickets purchasedLottos = LottoGenerator.buyLottos(lottoPurchaseAmount);
        resultUI.printBoughtLottos(purchasedLottos);

        return purchasedLottos;
    }
}