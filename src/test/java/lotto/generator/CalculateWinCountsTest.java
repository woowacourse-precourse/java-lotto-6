package lotto.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateWinCountsTest {
    @DisplayName("로또 번호 조합의 당첨 번호 개수를 올바르게 계산한다.")
    @Test
    void testCalculateWinCounts() {
        // Arrange
        List<List<Integer>> lottoNumberList = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(7, 8, 9, 10, 11, 12),
                List.of(1, 2, 3, 4, 5, 6)
        );
        List<Integer> lottoWinNumber = List.of(1, 2, 3, 4, 5, 6); // 당첨 번호
        int bonusNumber = 7; // 보너스 번호

        // Act
        List<Integer> winCounts = CalculateWinCounts.calculateWinCounts(lottoNumberList, lottoWinNumber, bonusNumber);

        // Assert
        assertThat(winCounts).containsExactly(6, 0, 6); // 당첨 번호 개수 확인
    }
}
