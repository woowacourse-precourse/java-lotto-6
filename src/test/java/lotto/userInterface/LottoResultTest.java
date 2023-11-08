package lotto.userInterface;

import lotto.domain.Lotto;
import lotto.domain.LottoResultAnalyzer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {

    @DisplayName("로또 결과(등수 계산) 기능 테스트")
    @Test
    void testCalculateWinnings() {

        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 2;

        List<Integer> winnings = LottoResultAnalyzer.calculateWinnings(lottos, winningNumbers, bonusNumber);

        // 예상되는 결과와 비교
        List<Integer> expectedWinnings = List.of(1, 0, 0, 0, 0);
        assertEquals(expectedWinnings, winnings);
    }
}
