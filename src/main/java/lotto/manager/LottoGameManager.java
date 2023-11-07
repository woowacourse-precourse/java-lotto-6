package lotto.manager;

import lotto.LottoStore;
import lotto.domain.LottoTickets;
import lotto.ui.InputUI;
import lotto.ui.ResultUI;
import lotto.ui.StatisticsUI;

/**
 * @author 민경수
 * @description lotto manager
 * @since 2023.11.04
 **********************************************************************************************************************/
public class LottoGameManager {

    public void start() {
        InputUI inputUI = new InputUI();
        ResultUI resultUI = new ResultUI();
        StatisticsUI statisticsUI = new StatisticsUI(inputUI, resultUI);

        LottoStore lottoStore = new LottoStore(inputUI, resultUI);

        LottoTickets boughtLottos = lottoStore.buyLotto();

        statisticsUI.printStatistic(boughtLottos);
    }

}