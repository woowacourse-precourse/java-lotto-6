package domain.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("TotalWinningResult 클래스 테스트")
public class TotalWinningResultTest {
    private TotalWinningResult totalWinningResult;

    @BeforeEach
    @DisplayName("테스트 전 초기화")
    public void setUp() {
        totalWinningResult = new TotalWinningResult();
    }

    @Test
    @DisplayName("increase 메서드 및 get 메서드 테스트")
    public void testIncreaseAndGet() {
        WinningResult winningResult = WinningResult.FIRST;

        // 처음에는 FIRST의 카운트가 0이어야 합니다.
        assertThat(totalWinningResult.get(winningResult)).isEqualTo(0);

        // FIRST의 카운트를 1 증가시킵니다.
        totalWinningResult.increase(winningResult);

        // 증가한 후에는 FIRST의 카운트가 1이어야 합니다.
        assertThat(totalWinningResult.get(winningResult)).isEqualTo(1);

        // FIRST의 카운트를 2 더 증가시킵니다.
        totalWinningResult.increase(winningResult);
        totalWinningResult.increase(winningResult);

        // 더 증가한 후에는 FIRST의 카운트가 3이어야 합니다.
        assertThat(totalWinningResult.get(winningResult)).isEqualTo(3);
    }

    @Test
    @DisplayName("여러 결과에 대한 increase 및 get 메서드 테스트")
    public void testIncreaseAndGetForMultipleResults() {
        // 여러 WinningResult 값으로 테스트합니다.
        WinningResult firstPlace = WinningResult.FIRST;
        WinningResult secondPlace = WinningResult.SECOND;

        // 처음에는 FIRST와 SECOND의 카운트가 모두 0이어야 합니다.
        assertThat(totalWinningResult.get(firstPlace)).isEqualTo(0);
        assertThat(totalWinningResult.get(secondPlace)).isEqualTo(0);

        // FIRST와 SECOND의 카운트를 각각 1씩 증가시킵니다.
        totalWinningResult.increase(firstPlace);
        totalWinningResult.increase(secondPlace);

        // 증가한 후에는 FIRST와 SECOND의 카운트가 각각 1이어야 합니다.
        assertThat(totalWinningResult.get(firstPlace)).isEqualTo(1);
        assertThat(totalWinningResult.get(secondPlace)).isEqualTo(1);
    }
}

