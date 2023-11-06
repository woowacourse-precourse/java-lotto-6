package lotto;

import lotto.common.Mission;
import lotto.controller.LottoController;

public class LottoMission implements Mission {
    @Override
    public void run() throws IllegalArgumentException {
        LottoController controller = new LottoController();
        controller.readPurchaseAmount();
        controller.issueRequiredAmountOfLottery();
        controller.showPurchaseInformation();
        controller.readWinningNumbers();
        controller.readBonusNumber();
        controller.showPortfolioResult();
    }
}
