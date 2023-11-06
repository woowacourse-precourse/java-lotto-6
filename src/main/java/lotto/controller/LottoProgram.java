package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.LottoStore;
import lotto.StatisticsService;
import lotto.model.Lotto;
import lotto.model.WiningStatistics;
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
        String money = inputView.printMoney();
        List<Lotto> lottos = purchaseLottoNumbers(Integer.parseInt(money));
        drawLottery(lottos);
    }

    private void drawLottery(List<Lotto> lottos) {
        String winingNumbers = inputView.printWiningNumbers();
        String bonusNumber = inputView.printBonusNumber();

        result(lottos, winingNumbers, bonusNumber);
    }

    private void result(List<Lotto> lottos, String winingNumbers, String bonusNumber) {
        StatisticsService statisticsService = new StatisticsService();
        WiningStatistics winingStatistics = statisticsService.calculateWiningStatistics(stringToList(winingNumbers),
                Integer.parseInt(bonusNumber), lottos);
        outputView.printWiningStatistics(winingStatistics);
    }

    private List<Integer> stringToList(String winingNumbers) {
        List<Integer> list = new ArrayList<>();
        for (String str : winingNumbers.split(",")) {
            list.add(Integer.valueOf(str));
        }
        return list;
    }

    private List<Lotto> purchaseLottoNumbers(int money) {
        List<Lotto> lottos = lottoStore.receiveLottoNumbers(money);
        outputView.printBuyingLotto(lottos);
        return lottos;
    }
}
