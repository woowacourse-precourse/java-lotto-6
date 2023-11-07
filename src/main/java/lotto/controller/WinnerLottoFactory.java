package lotto.controller;

import lotto.controller.numbercandidatestring.NumberCandidateString;
import lotto.controller.numbercandidatestring.NumberCandidateStrings;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.WinnerLotto;

public class WinnerLottoFactory {

    public  WinnerLotto generate(NumberCandidateStrings winningNumber, NumberCandidateString bonus) {
        Lotto lotto = new Lotto(winningNumber.toLottoNumberList());

        return new WinnerLotto(lotto, new LottoNumber(bonus.toNumber()));
    }
}
