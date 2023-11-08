package lotto;

import enums.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("judgeWinner 메서드로 1등한 로또면 HashMap의 First라는 key에 해당하는 value를 + 1")
    public void testJudgeWinner() {
        HashMap<Prize, Integer> ranking = new HashMap<>() {{
            put(Prize.FIRST, 0);
            put(Prize.SECOND, 0);
            put(Prize.THIRD, 0);
            put(Prize.FOURTH, 0);
            put(Prize.FIFTH, 0);
        }};
        Calculator.judgeWinner(6, ranking);
        assertEquals(1, ranking.get(Prize.FIRST));
}

    @Test
    public void testJudgeSecond() {
        HashMap<Prize, Integer> ranking = new HashMap<>() {{
            put(Prize.FIRST, 0);
            put(Prize.SECOND, 0);
            put(Prize.THIRD, 0);
            put(Prize.FOURTH, 0);
            put(Prize.FIFTH, 0);
        }};
        Calculator.judgeSecond(5, true, ranking);
        assertEquals(1, ranking.get(Prize.SECOND));
    }

    @Test
    public void testJudgeThird() {
        HashMap<Prize, Integer> ranking = new HashMap<>() {{
            put(Prize.FIRST, 0);
            put(Prize.SECOND, 0);
            put(Prize.THIRD, 0);
            put(Prize.FOURTH, 0);
            put(Prize.FIFTH, 0);
        }};
        Calculator.judgeThird(5, false, ranking);
        assertEquals(1, ranking.get(Prize.THIRD));
    }

    @Test
    public void testJudgeFourth() {
        HashMap<Prize, Integer> ranking = new HashMap<>() {{
            put(Prize.FIRST, 0);
            put(Prize.SECOND, 0);
            put(Prize.THIRD, 0);
            put(Prize.FOURTH, 0);
            put(Prize.FIFTH, 0);
        }};
        Calculator.judgeFourth(4, ranking);
        assertEquals(1, ranking.get(Prize.FOURTH));
    }

    @Test
    public void testJudgeFifth() {
        HashMap<Prize, Integer> ranking = new HashMap<>() {{
            put(Prize.FIRST, 0);
            put(Prize.SECOND, 0);
            put(Prize.THIRD, 0);
            put(Prize.FOURTH, 0);
            put(Prize.FIFTH, 0);
        }};
        Calculator.judgeFifth(3, ranking);
        assertEquals(1, ranking.get(Prize.FIFTH));
    }

    @Test
    public void testJudgeRanking() {
        HashMap<Prize, Integer> ranking = new HashMap<>() {{
            put(Prize.FIRST, 0);
            put(Prize.SECOND, 0);
            put(Prize.THIRD, 0);
            put(Prize.FOURTH, 0);
            put(Prize.FIFTH, 0);
        }};
        Calculator.judgeRanking(5, true, ranking);
        assertEquals(1, ranking.get(Prize.SECOND));
    }

    @Test
    public void testCalculateRate() {
        HashMap<Prize, Integer> ranking = new HashMap<>() {{
            put(Prize.FIRST, 1);
            put(Prize.SECOND, 0);
            put(Prize.THIRD, 0);
            put(Prize.FOURTH, 0);
            put(Prize.FIFTH, 2);
        }};
        float rate = Calculator.calculateRate(ranking, 3000);
        float expectedResult = (Prize.FIRST.price + 2 * Prize.FIFTH.price) / (float)3000 * 100;

        Assertions.assertThat(rate).isEqualTo(expectedResult);
    }


}
