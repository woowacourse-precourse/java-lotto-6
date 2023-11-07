package lotto.controller;

import java.util.List;
import lotto.controller.dto.ResultDto;
import lotto.controller.numbercandidatestring.NumberCandidateString;
import lotto.controller.numbercandidatestring.NumberCandidateStrings;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.domain.ProfitCalculator;
import lotto.domain.Rank;
import lotto.domain.lotto.WinnerLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final ProfitCalculator calculator;
    private final WinnerLottoFactory winnerLottoFactory;

    public LottoController(ProfitCalculator calculator, WinnerLottoFactory winnerLottoFactory) {
        this.calculator = calculator;
        this.winnerLottoFactory = winnerLottoFactory;
    }

    public void run() {
        try {
            NumberCandidateString numberCandidateString = new NumberCandidateString(InputView.collectionOfMoney());
            Money purchaseAmount = numberCandidateString.toMoney();
            confirmWinning(buyLotto(purchaseAmount), purchaseAmount);
        } catch (Exception e) {
            OutputView.renderingError(e.getMessage());
        }
    }

    private Lottos buyLotto(Money purchaseAmount) {
        Lottos lottos = Lottos.from(purchaseAmount.calcBillCount());

        OutputView.renderingPurchaseHistory(lottos.getList());
        return lottos;
    }

    private void confirmWinning(Lottos lottos, Money purchaseAmount) {
        WinnerLotto winnerLotto= winnerLottoFactory.generate(
                NumberCandidateStrings.from(InputView.receiveWinningNumber())
                ,new NumberCandidateString(InputView.receiveBonusNumber()));

        List<Rank> confirmResult = lottos.chargeResult(winnerLotto);
        Double profitRate = calculator.calcRate(calculator.calcProfit(confirmResult), purchaseAmount);

        OutputView.renderingResult(new ResultDto(confirmResult, profitRate));
    }

}
