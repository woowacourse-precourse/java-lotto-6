package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class LottoCalculatorTest {

    @BeforeEach
    void setUp() {
        LottoCalculator.initialize();
    }

    @Test
    void 모든_숫자가_일치했을_경우_확인() {
        // Given
        List<Integer> userLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // When
        int prize = LottoCalculator.calculatePrize(userLottoNumbers, winningLottoNumber, bonusNumber);

        // Then
        assertThat(prize).isEqualTo(2000000000);
        assertThat(LottoCalculator.getFinalMatchNumbers()).containsExactly(1, 0, 0, 0, 0, 0);
    }

    @Test
    void 보너스_번호와_함께_일치했을_경우() {
        // Given
        List<Integer> userLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 7);
        int bonusNumber = 6;

        // When
        int prize = LottoCalculator.calculatePrize(userLottoNumbers, winningLottoNumber, bonusNumber);

        // Then
        assertThat(prize).isEqualTo(30000000);
        assertThat(LottoCalculator.getFinalMatchNumbers()).containsExactly(0, 1, 0, 0, 0, 0);
    }

    @Test
    void 아무_번호도_일치하지_않았을_경우() {
        // Given
        List<Integer> userLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumber = Arrays.asList(7, 8, 9, 10, 11, 12);
        int bonusNumber = 13;

        // When
        int prize = LottoCalculator.calculatePrize(userLottoNumbers, winningLottoNumber, bonusNumber);

        // Then
        assertThat(prize).isEqualTo(0);
        assertThat(LottoCalculator.getFinalMatchNumbers()).containsExactly(0, 0, 0, 0, 0, 0);
    }
}