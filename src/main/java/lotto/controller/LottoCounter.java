package lotto.controller;

import lotto.controller.numbercandidatestring.NumberCandidateString;
import lotto.controller.numbercandidatestring.NumberCandidateStrings;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinnerLotto;
import lotto.domain.money.Money;
import lotto.view.InputView;

public class LottoCounter implements Counter {

    @Override
    public Lottos buyLotto() {
        NumberCandidateString numberCandidateString = new NumberCandidateString(InputView.collectionOfMoney());
        Money purchaseAmount = numberCandidateString.toMoney();

        return  Lottos.from(purchaseAmount.calcBillCount());

    }

    @Override
    public WinnerLotto generateWinnerLotto(Lotto lotto) {
        return new WinnerLotto(lotto, getBounus());

    }

    @Override
    public Lotto generateLotto() {
        NumberCandidateStrings from = NumberCandidateStrings.from(InputView.receiveWinningNumber());
        return new Lotto(from.toLottoNumberList());
    }

    private static LottoNumber getBounus() {
        NumberCandidateString numberCandidateString = new NumberCandidateString(InputView.receiveBonusNumber());
        return new LottoNumber(numberCandidateString.toNumber());
    }
}
