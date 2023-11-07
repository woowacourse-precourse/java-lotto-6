package lotto.controller;

import java.util.List;
import lotto.LottoStore;
import lotto.StatisticsService;
import lotto.model.Lotto;
import lotto.model.LottoMoney;
import lotto.model.WiningStatistics;
import lotto.utils.StringUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoProgram {
    InputView inputView;
    OutputView outputView;
    LottoStore lottoStore;

    public LottoProgram(InputView inputView, OutputView outputView, LottoStore lottoStore) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoStore = lottoStore;
    }

    public void start() {
        LottoMoney money = inputView.printMoney();
        List<Lotto> lottos = purchaseLottoNumbers(money);
        drawLottery(lottos);
    }

    private List<Lotto> purchaseLottoNumbers(LottoMoney money) {
        List<Lotto> lottos = lottoStore.receiveLottoNumbers(money);
        outputView.printBuyingLotto(lottos);
        return lottos;
    }

    private void drawLottery(List<Lotto> lottos) {
        String winingNumbers = inputView.printWiningNumbers();
        String bonusNumber = inputView.printBonusNumber();

        result(lottos, winingNumbers, bonusNumber);
    }

    private void result(List<Lotto> lottos, String winingNumbers, String bonusNumber) {
        StatisticsService statisticsService = new StatisticsService();
        WiningStatistics winingStatistics =
                statisticsService.calculateWiningStatistics(StringUtils.asListByDelimiter(winingNumbers, ",")
                        , Integer.parseInt(bonusNumber), lottos);
        outputView.printWiningStatistics(winingStatistics);
    }
}
