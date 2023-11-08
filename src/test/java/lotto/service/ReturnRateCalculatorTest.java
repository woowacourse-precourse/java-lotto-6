package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReturnRateCalculatorTest {
    private Lotto prizeLotto;

    private Lottos lottos;

    private int bonusNumber;

    @BeforeEach
    void init() {
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = List.of(11, 21, 31, 32, 33, 34);
        List<Integer> numbers3 = List.of(12, 22, 32, 42, 43, 44);
        List<Integer> numbers4 = List.of(1, 2, 3, 41, 42, 43);
        Lotto lotto1 = new Lotto(numbers1);
        Lotto lotto2 = new Lotto(numbers2);
        Lotto lotto3 = new Lotto(numbers3);
        lottos = new Lottos();
        lottos.save(lotto1);
        lottos.save(lotto2);
        lottos.save(lotto3);
        bonusNumber = 7;
        prizeLotto = new Lotto(numbers4);
    }

    @DisplayName("수익률 계산이 잘 작동된다")
    @Test
    void createReturnRateCalculator() {
        PrizeCalculator prizeCalculator = new PrizeCalculator(prizeLotto, lottos, bonusNumber);
        List<Map.Entry<Integer, Boolean>> results = prizeCalculator.caculatePrize();

        ReturnRateCalculator returnRateCalculator = new ReturnRateCalculator(results, 3000);
        double rate = returnRateCalculator.calculateReturnRate();
        assertEquals(166, (int)rate);
    }
}