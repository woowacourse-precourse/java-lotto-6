package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lottery.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class WinningLottoTest {
    @Test
    void 당첨_번호를_성공적으로_생성한다() {
        // Given
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // When
        WinningLotto winningLotto = WinningLotto.create(winningLottoNumbers, bonusNumber);
        String expectedWinningNumbers = winningLottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        String winningNumbers = winningLotto.getNumberList()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        // Then
        assertThat(winningNumbers).isEqualTo(expectedWinningNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);

    }

    @Nested
    class 예외_테스트 {
        @ParameterizedTest(name = "보너스 번호 {0}을 입력하면 예외가 발생한다.")
        @ValueSource(ints = {0, 46})
        void 범위를_벗어난_보너스_번호(int bonusNumber) {
            // Given
            List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);

            // When
            assertThatThrownBy(() -> WinningLotto.create(winningLottoNumbers, bonusNumber))
                    // Then
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("당첨 번호와 중복된 보너스 번호를 가지면 예외가 발생한다.")
        void duplicateBonusNumberException() {
            // Given
            List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
            int duplicateBonusNumber = 1;

            // When
            assertThatThrownBy(() -> WinningLotto.create(winningLottoNumbers, duplicateBonusNumber))
                    // Then
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
