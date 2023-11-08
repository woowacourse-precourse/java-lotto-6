package service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.service.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StatisticsTest {
//    StatisticsService statisticsService;
//    List<Lotto> lottos = new ArrayList<>();
//    Lotto lotto;
//
//    @BeforeEach
//    void getInstance() {
//        WinningLottoFactory winningLottoFactory = WinningLottoFactoryImpl.getInstance();
//        lottos.add(new Lotto(List.of(1,2,3,10,11,12)));
//        lottos.add(new Lotto(List.of(1,2,3,10,11,12)));
//        lottos.add(new Lotto(List.of(1,2,3,10,11,12)));
//        lottos.add(new Lotto(List.of(11,12,13,14,15,16)));
//        lottos.add(new Lotto(List.of(11,12,13,14,15,16)));
//        lotto = winningLottoFactory.winningLotto("1,2,3,4,5,6");
//        BonusNumber bonusNumber = winningLottoFactory.bonusNumber("7", lotto);
//        statisticsService = StatisticsServiceImpl.getInstance(lottos, lotto, bonusNumber);
//    }
//
//    @Test
//    @DisplayName("통계 확인")
//    void calculateRevenueRate() {
//        Result result = statisticsService.calculateResult();
//        double revenueRate = statisticsService.calculateRevenueRate(lottos, result);
//        Assertions.assertThat(revenueRate).isEqualTo(300.0);
//    }

    // 싱글톤 구현하니 수익률 계산이 여러 곳에서 이루어지면 다른 값이 들어감... 문제 발생
}
