package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeCalculatorTest {

    private Lotto prizeLotto;

    private Lottos lottos;

    private int bonusNumber;

    @BeforeEach
    void init() {
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = List.of(11, 21, 31, 41, 42, 43);
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

    @DisplayName("Prize의 계산이 정상 작동한다.")
    @Test
    void createCaculatePrize() {

        PrizeCalculator prizeCalculator = new PrizeCalculator(prizeLotto, lottos, bonusNumber);
        List<Map.Entry<Integer, Boolean>> result = prizeCalculator.caculatePrize();
        int matchNum = result.get(0).getKey();
        assertEquals(3, result.size());
        assertEquals(3, matchNum);
    }
}