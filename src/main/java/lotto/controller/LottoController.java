package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.generator.AutoLottoGenerator;
import lotto.domain.generator.LottosMachine;
import lotto.domain.generator.RandomNumbersGenerator;
import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMoney;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.result.WinningResult;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView lottoView;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void play() {
        LottoMoney lottoMoney = new LottoMoney(lottoView.askPurchaseMoney());

        LottosMachine lottosMachine = new LottosMachine(
                new AutoLottoGenerator(new RandomNumbersGenerator()));
        Lottos lottos = lottosMachine.buy(lottoMoney);
        lottoView.printLottos(lottos);

        WinningLotto winningLotto = new WinningLotto(new Lotto(lottoView.askLottoNumbers()),
                new BonusNumber(lottoView.askBonusNumber()));

        WinningResult winningResult = lottos.calculateWinningResult(winningLotto);
        float profit = winningResult.calculateProfitRate(lottoMoney);
        lottoView.printWinningResult(winningResult);
        lottoView.printWinningProfit(profit);
    }
}
