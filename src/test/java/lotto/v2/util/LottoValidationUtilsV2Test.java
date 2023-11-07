package lotto.v2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class LottoValidationUtilsV2Test {
    @Test
    @DisplayName("로또 번호가 6개가 아니면 예외를 던진다")
    void should_ThrowException_When_LottoNumbersSizeIsNotSix() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> LottoValidationUtilsV2.checkValidLottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 번호가 6개일 때 예외를 던지지 않는다")
    void should_NotThrowException_When_LottoNumbersSizeIsSix() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatNoException().isThrownBy(() -> LottoValidationUtilsV2.checkValidLottoNumbers(numbers));
    }

    @Test
    @DisplayName("로또 번호가 범위를 벗어나면 예외를 던진다")
    void should_ThrowException_When_LottoNumbersAreOutOfValidRange() {
        // given
        List<Integer> numbers = Arrays.asList(0, 2, 3, 4, 5, 46);

        // when & then
        assertThatThrownBy(() -> LottoValidationUtilsV2.checkValidLottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 범위를 벗어나면 예외를 던진다")
    void should_ThrowException_When_BonusNumberIsOutOfValidRange() {
        // given
        int bonusNumber = 0;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> LottoValidationUtilsV2.checkValidBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외를 던진다")
    void should_ThrowException_When_BonusNumberIsDuplicatedInWinningNumbers() {
        // given
        int bonusNumber = 3;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> LottoValidationUtilsV2.checkValidBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 유효하고 당첨 번호와 중복되지 않을 때 예외를 던지지 않는다")
    void should_NotThrowException_When_BonusNumberIsValid() {
        // given
        int bonusNumber = 7;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatNoException().isThrownBy(() -> LottoValidationUtilsV2.checkValidBonusNumber(bonusNumber, winningNumbers));
    }

}