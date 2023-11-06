package lotto.MyTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Model.LottoMatch;
import lotto.Model.LottoPrize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchTest {

    private List<List<Integer>> totalLottoNumbers;
    private List<Integer> winningNumbers;

    @BeforeEach
    void setUp() {
        totalLottoNumbers = new ArrayList<>();
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨 번호와 일치하는 로또의 수를 올바르게 카운트한다.")
    @Test
    void testCountMatchingNumbers() {
        // Arrange
        List<Integer> lotto1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lotto2 = Arrays.asList(1, 2, 3, 4, 5, 7);
        totalLottoNumbers.add(lotto1);
        totalLottoNumbers.add(lotto2);
        int bonus = 7;

        // Act
        List<Integer> result = LottoMatch.countMatchingNumbers(totalLottoNumbers, winningNumbers, bonus);

        // Assert
        assertThat(result).hasSize(LottoPrize.values().length);
        assertThat(result.get(LottoPrize.FIRST.ordinal())).isEqualTo(1);
        assertThat(result.get(LottoPrize.SECOND.ordinal())).isEqualTo(1);
        assertThat(result.get(LottoPrize.THIRD.ordinal())).isEqualTo(0);
        assertThat(result.get(LottoPrize.FOURTH.ordinal())).isEqualTo(0);
        assertThat(result.get(LottoPrize.FIFTH.ordinal())).isEqualTo(0);
    }

    @DisplayName("보너스 번호의 일치여부를 판단한다.")
    @Test
    void testIsContainBonus() {
        // Arrange
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonus = 6;

        // Act
        boolean result = LottoMatch.isContainBonus(lottoNumbers, bonus);

        // Assert
        assertThat(result).isTrue();
    }
}
