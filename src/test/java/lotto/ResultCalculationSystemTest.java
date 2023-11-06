package lotto;

import lotto.dto.Lotto;
import lotto.dto.ResultCalculationSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ResultCalculationSystemTest {
    ResultCalculationSystem resultCalculationSystem = new ResultCalculationSystem();

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