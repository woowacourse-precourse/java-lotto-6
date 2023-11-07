package lotto.controller;

import lotto.controller.dto.LottosDto;
import lotto.controller.dto.WinningResultDto;
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
        LottoMoney lottoMoney = createLottoMoney();
        Lottos lottos = buyLottosBy(lottoMoney);
        WinningLotto winningLotto = createWinningLotto();
        WinningResult winningResult = createWinningResultWith(lottos, winningLotto);
        printResult(winningResult, lottoMoney);

    }
    private LottoMoney createLottoMoney() {
        while (true) {
            try {
                return new LottoMoney(lottoView.askPurchaseMoney());
            } catch (IllegalArgumentException e) {
                lottoView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Lottos buyLottosBy(LottoMoney lottoMoney) {
        LottosMachine lottosMachine = new LottosMachine(
                new AutoLottoGenerator(new RandomNumbersGenerator()));
        Lottos lottos = lottosMachine.buy(lottoMoney);
        lottoView.printLottos(LottosDto.from(lottos));
        return lottos;
    }
    private WinningLotto createWinningLotto() {
        while (true) {
            try {
                return new WinningLotto(new Lotto(lottoView.askLottoNumbers()),
                        new BonusNumber(lottoView.askBonusNumber()));
            } catch (IllegalArgumentException e) {
                lottoView.printErrorMessage(e.getMessage());
            }
        }
    }
    private WinningResult createWinningResultWith(Lottos lottos, WinningLotto winningLotto) {
        return lottos.calculateWinningResult(winningLotto);
    }

    private void printResult(WinningResult winningResult, LottoMoney lottoMoney) {
        WinningResultDto winningResultDto = WinningResultDto.of(winningResult.getResult());
        lottoView.printWinningResult(winningResultDto);
        lottoView.printWinningProfit(winningResult.calculateProfitRate(lottoMoney));
    }
}
