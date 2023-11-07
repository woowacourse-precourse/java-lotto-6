package lotto.domain;

import lotto.config.LottoPrize;
import lotto.view.OutputView;

public class LottoController {
    private final LottoMachine lottoMachine;
    private final Money money;
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;
    private final LottoResult lottoResult;

    public LottoController() {
        money = InputController.getMoney();
        lottoMachine = new LottoMachine(money.getMoney());

        OutputView.printLottoCount(lottoMachine.getLottosCount(money.getMoney()));
        OutputView.printLottos(lottoMachine.getLottos());

        winningNumbers = InputController.getWinningNumbers();
        bonusNumber = InputController.getBonusNumber(winningNumbers.getWinningNumbers());
        lottoResult = new LottoResult();
    }

    public void activate() {
        setLottoResult();

        OutputView.printLottoResult(lottoResult.getLottoResult());
        OutputView.printLottoProfit(lottoResult.calculateProfit(money.getMoney()));
    }

    private void setLottoResult() {
        lottoMachine.getLottos()
                .forEach(lotto -> lottoResult.setResult(getPrize(lotto)));
    }

    private LottoPrize getPrize(Lotto lotto) {
        return new LottoDraw(lotto.getNumbers(), winningNumbers.getWinningNumbers(), bonusNumber.getBonusNumber())
                .getPrize();
    }

}