package lotto.Model;

import lotto.Domain.LottoGroup;
import lotto.Domain.LottoResult.LottoResult;
import lotto.Domain.WinningLotto.WinningLotto;

public class LottoResultHandlerModel {

    private LottoResult lottoResult;
    private WinningLotto winningLotto;
    private LottoGroup lottoGroup;

    public LottoResultHandlerModel(WinningLotto winningLotto, LottoGroup lottoGroup) {
        this.winningLotto = winningLotto;
        this.lottoGroup = lottoGroup;
    }
}
