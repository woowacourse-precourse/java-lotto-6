package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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

    @DisplayName("로또 확인 결과가 일치하는지 테스트")
    @Test
    public void checkOneLottoTest() {
        Game game = new Game();

        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // 테스트 케이스 1: 모든 번호가 일치
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int[] result1 = game.checkOneLotto(lotto1, winningNumbers, bonusNumber);
        assertArrayEquals(new int[]{6, 0}, result1);

        // 테스트 케이스 2: 5개 일치 + 보너스 볼 일치
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 보너스 볼 일치
        int[] result2 = game.checkOneLotto(lotto2, winningNumbers, bonusNumber);
        assertArrayEquals(new int[]{5, 1}, result2);

        // 테스트 케이스 3: 3개 일치
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));
        int[] result3 = game.checkOneLotto(lotto3, winningNumbers, bonusNumber);
        assertArrayEquals(new int[]{3, 0}, result3);

        // 테스트 케이스 4: 모든 번호 불일치
        Lotto lotto4 = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15));
        int[] result4 = game.checkOneLotto(lotto4, winningNumbers, bonusNumber);
        assertArrayEquals(new int[]{0, 0}, result4);
    }

    @Test
    public void getTotalReturnTest() {
        Game game = new Game();
        int[] winningStatistics = {1, 2, 3, 4, 5}; // 예시 수치

        int totalReturn = game.getTotalReturn(winningStatistics);

        // 예상 결과 계산
        int expectedTotalReturn = 1 * 2000000000 + 2 * 30000000 + 3 * 1500000 + 4 * 50000 + 5 * 5000;

        // 결과 비교
        assertEquals(expectedTotalReturn, totalReturn);
    }
}
