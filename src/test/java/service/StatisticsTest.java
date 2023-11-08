package service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StatisticsTest {
    StatisticsService statisticsService;
    List<Lotto> lottos = new ArrayList<>();

    @BeforeEach
    void getInstance() {
        WinningLottoFactory winningLottoFactory = WinningLottoFactoryImpl.getInstance();
        lottos.add(new Lotto(List.of(1,2,3,10,11,12)));
        lottos.add(new Lotto(List.of(1,2,3,10,11,12)));
        lottos.add(new Lotto(List.of(1,2,3,10,11,12)));
        lottos.add(new Lotto(List.of(11,12,13,14,15,16)));
        lottos.add(new Lotto(List.of(11,12,13,14,15,16)));
        Lotto lotto = winningLottoFactory.winningLotto("1,2,3,4,5,6");
        BonusNumber bonusNumber = winningLottoFactory.bonusNumber("7", lotto);
        statisticsService = StatisticsServiceImpl.getInstance(lottos, lotto, bonusNumber);
    }

    @Test
    @DisplayName("통계 확인")
    void calculateRevenueRate() {
        Result result = statisticsService.calculateResult();
        double revenueRate = statisticsService.calculateRevenueRate(lottos, result);
        Assertions.assertEquals(revenueRate, Math.round((15000 / 5000 * 100)*10)/10.0);
    }
}
