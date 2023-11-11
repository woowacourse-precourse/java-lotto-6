package lotto.domain.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

public class LottoResultDto {
    private final LottoList lottoList;
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private LottoResultDto(LottoList lottoList, Lotto winningLotto, LottoNumber bonusNumber) {
        this.lottoList = lottoList;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoResultDto Of(LottoList lottoList, Lotto winningLotto, LottoNumber bonusNumber) {
        return new LottoResultDto(lottoList, winningLotto, bonusNumber);
    }

    public int getCost() {
        return lottoList.size() * Money.EACH_LOTTO;
    }

    public LottoList getLottoList() {
        return lottoList;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

}
