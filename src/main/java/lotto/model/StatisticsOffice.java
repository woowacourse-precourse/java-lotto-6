package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsOffice {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private StatisticsOffice(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static StatisticsOffice registerWinningLotto(List<Integer> winningLotto, Integer bonusNumber) {
        return new StatisticsOffice(new Lotto(winningLotto), new LottoNumber(bonusNumber));
    }




}
