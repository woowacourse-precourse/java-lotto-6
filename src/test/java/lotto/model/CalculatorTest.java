package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;
    private Map<Rank, Integer> rankResult;

    @BeforeEach
    void setUp() {
        Lotto winnerLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto noRankLotto = new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10));
        Lotto firstRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> userLottos = new ArrayList<>(Arrays.asList(noRankLotto, firstRankLotto));
        int bonusNumber = 7;
        calculator = new Calculator(winnerLotto, userLottos, bonusNumber);
        rankResult = calculator.calculateResult();
    }

    @DisplayName("추첨 결과는 등수가 key, 개수가 value인 Map에 들어간다")
    @Test
    void calculateResultTest() {
        assertEquals(1, rankResult.getOrDefault(Rank.FIRST, 0));
        assertEquals(0, rankResult.getOrDefault(Rank.SECOND, 0));
        assertEquals(1, rankResult.getOrDefault(Rank.NO_RANK, 0));
    }

    @DisplayName("수익률을 계산하는 메서드 테스트")
    @Test
    void calculateRateOfReturn() {
        assertEquals(100000000, calculator.calculateRateOfReturn(rankResult));
    }

}
