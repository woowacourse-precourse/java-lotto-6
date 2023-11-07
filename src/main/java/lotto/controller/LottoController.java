package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoUtils;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        settingLottoGame();
    }

    private void settingLottoGame() {
        AmountLotto amountLotto = new AmountLotto(requestPurchaseAmountLotto());
        MyLottos myLottos = new MyLottos(amountLotto.calculateAmountLotto());

        OutputView.printMyLottos(amountLotto.calculateAmountLotto(), myLottos);
        WinningLotto winningLotto = new WinningLotto(requestWinningLotto(), requestWinningBonus());

        totalLottoRanking(amountLotto, myLottos, winningLotto);
    }

    private void totalLottoRanking(AmountLotto amountLotto, MyLottos myLottos, WinningLotto winningLotto) {
        ResultLotto resultLotto = new ResultLotto(RankingLotto.makeHashMapLottoRanking());

        resultLotto.matchTotalLotto(amountLotto, myLottos, winningLotto);

        OutputView.winningResult(resultLotto);
        OutputView.printLottoYield(resultLotto.totalReward(amountLotto));
    }

    public String requestPurchaseAmountLotto() {
        return LottoUtils.requestInputWithValidator(InputView::lottoPurchaseAmountInput, LottoValidator::amountInputValidator);
    }

    public String requestWinningLotto() {
        return LottoUtils.requestInputWithValidator(InputView::winningLottoInput, LottoValidator::winningLottoValidator);
    }

    public String requestWinningBonus() {
        return LottoUtils.requestInputWithValidator(InputView::bonusLottoInput, LottoValidator::inputWinningBonusValidator);
    }


}
