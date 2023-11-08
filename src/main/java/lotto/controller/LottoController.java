package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningNumbers;
import lotto.model.WinningRate;
import lotto.util.IntUtil;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    Money money;
    Lottos lottos;
    BonusNumber bonusNumber;
    WinningNumbers winningNumbers;
    WinningRate winningRate;


    public void processLotto() {
        money = Money.makeMoney(IntUtil.makeIntegerNumber(InputView.inputMoney()));
        lottos = makeLottos(buyLotto(money.getMoney()));
        OutputView.showLottoNumbers(lottos.getLottos());
        Lotto winningLotto = Lotto.makeLotto(IntUtil.makeIntegerNumbers(InputView.readLotto()));
        bonusNumber = BonusNumber.makeBonusNumber(
                IntUtil.makeIntegerNumber(InputView.readBonusNumber(winningLotto.getLottoNumbers())));
        winningNumbers = WinningNumbers.makeWinningNumbers(winningLotto, bonusNumber);
        OutputView.showLottoNumbers(lottos.getLottos());
        winningRate = WinningRate.makeWinningRate(lottos.getLottos(), winningNumbers);
        OutputView.showResult(winningRate.getWinningCount(), money.getMoney(), winningRate.getProfit());
    }

    private int buyLotto(int money) {
        return money / 1000;
    }

    public Lottos makeLottos(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(Lotto.makeLotto(RandomNumberGenerator.generateLottoNumber()));
        }
        return Lottos.makeLottos(lottoList);
    }
}
