package lotto.Model;

import java.util.ArrayList;
import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGroup;
import lotto.Domain.LottoResult.LottoResult;
import lotto.Domain.WinningLotto.WinningLotto;

public class LottoResultHandlerModel {

    private LottoResult lottoResult;
    private WinningLotto winningLotto;
    private LottoGroup lottoGroup;

    public LottoResultHandlerModel(WinningLotto winningLotto, LottoGroup lottoGroup) {
        lottoResult = new LottoResult();
        this.winningLotto = winningLotto;
        this.lottoGroup = lottoGroup;
    }


    public Integer checkWinning(Lotto winningLotto, Lotto purchasedLotto) {
        List<Integer> matchNumbers = new ArrayList<>(purchasedLotto.getNumbers());
        matchNumbers.retainAll(winningLotto.getNumbers());
        return matchNumbers.size();
    }
}
