package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @DisplayName("개수에 따른 로또 랭킹 확인")
    @Test
    public void testRanking() {
        Game game = new Game();

        // 테스트 케이스 1: 6개 일치
        int[] result1 = {6, 0};
        int rank1 = game.ranking(result1);
        assertEquals(1, rank1);

        // 테스트 케이스 2: 5개 일치 + 보너스 볼 1개 일치
        int[] result2 = {5, 1};
        int rank2 = game.ranking(result2);
        assertEquals(2, rank2);

        // 테스트 케이스 3: 5개 일치 + 보너스 볼 0개 일치
        int[] result3 = {5, 0};
        int rank3 = game.ranking(result3);
        assertEquals(3, rank3);

        // 테스트 케이스 4: 4개 일치
        int[] result4 = {4, 0};
        int rank4 = game.ranking(result4);
        assertEquals(4, rank4);

        // 테스트 케이스 5: 3개 일치
        int[] result5 = {3, 0};
        int rank5 = game.ranking(result5);
        assertEquals(5, rank5);

        // 테스트 케이스 6: 나머지 모든 경우
        int[] result6 = {0, 0};
        int rank6 = game.ranking(result6);
        assertEquals(6, rank6);
    }
}
