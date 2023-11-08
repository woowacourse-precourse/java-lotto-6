package lotto.controller;

import lotto.Lotto;
import lotto.model.GameMoney;
import lotto.model.WinLotto;
import lotto.model.WinLottoPlaceCount;

import java.util.List;

public interface CountWinLotto {

    public double getRateMoney(WinLottoPlaceCount winLottoPlaceCount, GameMoney gameMoney);

    public WinLottoPlaceCount lottoPlaceCount(WinLotto winLotto, List<Lotto> myLottos);


}
