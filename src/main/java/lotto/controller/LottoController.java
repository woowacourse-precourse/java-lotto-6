package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Store;
import lotto.service.StatisticProducer;

import java.util.List;

public class LottoController {
    private Store store;
    private StatisticProducer statisticProducer;

    public LottoController(Store store, StatisticProducer statisticProducer) {
        this.store = store;
        this.statisticProducer = statisticProducer;
    }

    public void operate(){
        Lottos lottos = store.sell();
    }


}
