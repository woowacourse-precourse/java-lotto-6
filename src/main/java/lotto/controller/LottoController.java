package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Statistic;
import lotto.domain.WinningLotto;
import lotto.service.LottoBroadCast;
import lotto.service.StatisticProducer;
import lotto.service.Store;
import lotto.view.impl.StatisticView;

public class LottoController {
    private Store store;
    private StatisticProducer statisticProducer;
    private StatisticView statisticView;
    private LottoBroadCast lottoBroadCast;

    public LottoController(Store store, StatisticProducer statisticProducer, StatisticView statisticView,
                           LottoBroadCast lottoBroadCast) {
        this.store = store;
        this.statisticProducer = statisticProducer;
        this.statisticView = statisticView;
        this.lottoBroadCast = lottoBroadCast;
    }

    public void operate(){
        Lottos lottos = store.sell();
        WinningLotto winningLotto = lottoBroadCast.announceWinningLotto();
        Statistic statistic = statisticProducer.produce(lottos, winningLotto, Money.LOTTO_PRICE);
        statisticView.outputView(statistic);
    }

}
