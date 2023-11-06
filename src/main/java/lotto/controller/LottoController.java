package lotto.controller;

import java.util.HashMap;
import lotto.domain.LottoNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.NumberCandidateString;
import lotto.domain.Rank;
import lotto.domain.WinnerLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        Lottos lottos = issueLottos();
        OutputView.printPurchaseHistory(lottos.getList());

        String winningNumber = InputView.receiveWinningNumber();
        NumberCandidateStrings numberCandidateStrings = NumberCandidateStrings.valueOf(winningNumber.split(","));
        Lotto lotto = new Lotto(numberCandidateStrings.toLottoNumberList());

        NumberCandidateString bonusNumber = new NumberCandidateString(InputView.receiveBonusNumber());
        LottoNumber bounus = new LottoNumber(bonusNumber.getNumber());

        WinnerLotto winnerLotto = new WinnerLotto(lotto, bounus);
        HashMap<Rank,Integer> result=lottos.chargeResult(winnerLotto);
    }

    private Lottos issueLottos() {
        NumberCandidateString numberCandidateString = new NumberCandidateString(InputView.collectionOfMoney());
        Integer amount = numberCandidateString.getNumber();
        Money money = Money.of(amount);

        return Lottos.from(money.calcBillCount());
    }

}
