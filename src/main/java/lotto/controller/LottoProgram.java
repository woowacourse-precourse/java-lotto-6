package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.controller.service.LottoService;
import lotto.controller.service.StatisticsService;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoMoney;
import lotto.model.WiningNumbers;
import lotto.model.WiningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoProgram {
    InputView inputView;
    OutputView outputView;
    LottoService lottoService;

    public LottoProgram(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void start() {
        LottoMoney money = inputView.printMoney();
        List<Lotto> lottos = purchaseLottoNumbers(money);
        drawLottery(lottos);
    }

    private List<Lotto> purchaseLottoNumbers(LottoMoney money) {
        List<Lotto> lottos = lottoService.createLottoNumbers(money);
        outputView.printBuyingLotto(lottos);
        return lottos;
    }

    private void drawLottery(List<Lotto> lottos) {
        Lotto numbers = inputView.printWiningNumbers();
        Bonus bonusNumber = inputView.printBonusNumber();
        WiningNumbers winingNumbers = new WiningNumbers(numbers, bonusNumber);
        result(lottos, winingNumbers);
    }

    private void result(List<Lotto> lottos, WiningNumbers winingNumbers) {
        StatisticsService statisticsService = new StatisticsService();
        WiningStatistics winingStatistics =
                statisticsService.calculateWiningStatistics(winingNumbers, lottos);
        outputView.printWiningStatistics(winingStatistics);
        Console.close();
    }
}
