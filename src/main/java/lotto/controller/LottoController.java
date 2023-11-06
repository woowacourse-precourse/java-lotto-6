package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.NumberCandidateString;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        //Todo
        Lottos lottos = issueLottos();
        OutputView.printPurchaseHistory(lottos.getList());

        String winningNumber = InputView.receiveWinningNumber();
        NumberCandidateStrings numberCandidateStrings = NumberCandidateStrings.valueOf(winningNumber.split(","));
        Lotto lotto = new Lotto(numberCandidateStrings.toLottoNumberList());

        NumberCandidateString bonusNumber = new NumberCandidateString(InputView.receiveBonusNumber());
        LottoNumber number = new LottoNumber(bonusNumber.getNumber());
    }

    private Lottos issueLottos() {
        NumberCandidateString numberCandidateString = new NumberCandidateString(InputView.collectionOfMoney());
        Integer amount = numberCandidateString.getNumber();
        Money money = Money.of(amount);

        Lottos lottos = Lottos.from(money.calcBillCount());

        return lottos;
    }

}
