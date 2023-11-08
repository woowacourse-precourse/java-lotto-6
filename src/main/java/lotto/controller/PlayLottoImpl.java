package lotto.controller;

import lotto.Lotto;
import lotto.model.GameMoney;
import lotto.model.WinLotto;
import lotto.model.WinLottoPlaceCount;
import lotto.view.OutputView;

import java.util.List;

public class PlayLottoImpl implements PlayLotto {

    CountWinLotto countWinLotto;
    GetBuyNumber getBuyNumber;
    GetMyLottos getMyLottos;
    GetWinLotto getWinLotto;
    OutputView outputView;

    public PlayLottoImpl(CountWinLotto countWinLotto, GetBuyNumber getBuyNumber, GetMyLottos getMyLottos,
                         GetWinLotto getWinLotto, OutputView outputView) {
        this.countWinLotto = countWinLotto;
        this.getBuyNumber = getBuyNumber;
        this.getMyLottos = getMyLottos;
        this.getWinLotto = getWinLotto;
        this.outputView = outputView;
    }

    public void playLotto() {
        GameMoney gameMoney = getBuyNumber.getBuyNumber();
        List<Lotto> myLottos = getMyLottos.getMyLottos(gameMoney);
        outputView.myLottos(myLottos, gameMoney.getGameCount());
        WinLotto winLotto = getWinLotto.getWinLotto();
        WinLottoPlaceCount winLottoPlaceCount = countWinLotto.lottoPlaceCount(winLotto, myLottos);
        double rateMoney = countWinLotto.getRateMoney(winLottoPlaceCount, gameMoney);
        outputView.lottoResult(winLottoPlaceCount.getWinLottoPlaceCount(), rateMoney);
    }

}
