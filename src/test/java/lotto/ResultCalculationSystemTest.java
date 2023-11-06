package lotto;

import lotto.domain.Lotto;
import lotto.service.ResultCalculationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ResultCalculationSystemTest {
    ResultCalculationService resultCalculationSystem = new ResultCalculationService();

    @BeforeEach
    void init() {
    }

    @Test
    void initAndSortWinningAndBonusNumbers() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        }
        //resultCalculationSystem.makeWinningResult();
    }

}