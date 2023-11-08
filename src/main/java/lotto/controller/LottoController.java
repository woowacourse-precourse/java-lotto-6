package lotto.controller;

import java.util.List;
import lotto.controller.dto.ResultDto;
import lotto.controller.numbercandidatestring.NumberCandidateString;
import lotto.controller.numbercandidatestring.NumberCandidateStrings;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.domain.ProfitCalculator;
import lotto.domain.Rank;
import lotto.domain.lotto.WinnerLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final ProfitCalculator calculator;

    public LottoController(ProfitCalculator calculator) {
        this.calculator = calculator;
    }

    public void run() {
        confirmWinning(buyLotto());
    }

    private Lottos buyLotto() {
        try {
            NumberCandidateString numberCandidateString = new NumberCandidateString(InputView.collectionOfMoney());
            Money purchaseAmount = numberCandidateString.toMoney();
            Lottos lottos = Lottos.from(purchaseAmount.calcBillCount());

            OutputView.renderingPurchaseHistory(lottos.getList());
            return lottos;
        }catch (IllegalArgumentException e){
            OutputView.renderingError(e.getMessage());
            return buyLotto();
        }

    }

    private void confirmWinning(Lottos lottos) {
        WinnerLotto winnerLotto = getWinnerLotto();

        List<Rank> confirmResult = lottos.chargeResult(winnerLotto);
        Double profitRate = calculator.calcRate(calculator.calcProfit(confirmResult), lottos.toMoney());

        OutputView.renderingResult(new ResultDto(confirmResult, profitRate));
    }

    private WinnerLotto getWinnerLotto() {
        return getWinnerLotto(getLotto());

    }

    private static WinnerLotto getWinnerLotto(Lotto lotto) {
        try {
            return new WinnerLotto(lotto, getBounus());
        }catch (IllegalArgumentException e){
            OutputView.renderingError(e.getMessage());
            return getWinnerLotto(lotto);
        }
    }

    private static LottoNumber getBounus() {
        NumberCandidateString numberCandidateString = new NumberCandidateString(InputView.receiveBonusNumber());
        return new LottoNumber(numberCandidateString.toNumber());
    }

    private static Lotto getLotto() {
        try {
            NumberCandidateStrings from = NumberCandidateStrings.from(InputView.receiveWinningNumber());
            return new Lotto(from.toLottoNumberList());
        }catch (IllegalArgumentException e){
            OutputView.renderingError(e.getMessage());
            return getLotto();
        }
    }
}
