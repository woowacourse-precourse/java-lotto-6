package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WinningInfoTest {

    @DisplayName("보너스 번호가 당첨 번호에 포함된 경우 예외를 발생시킨다.")
    @Test
    void validateBonusNumber() {
        // given
        int bonusNumber = 1;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> WinningInfo.from(winningNumbers, bonusNumber)
        );
    }

    @DisplayName("당첨 번호가 6개가 아닌 경우 예외를 발생시킨다.")
    @Test
    void validateSize() {
        // given
        int bonusNumber = 7;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5);

        // when & then
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> WinningInfo.from(winningNumbers, bonusNumber)
        );
    }

    @DisplayName("당첨 번호가 1 ~ 45 사이의 숫자가 아닌 경우 예외를 발생시킨다.")
    @Test
    void validateNumberRange() {
        // given
        int bonusNumber = 7;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);

        // when & then
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> WinningInfo.from(winningNumbers, bonusNumber)
        );
    }

    @DisplayName("보너스 번호가 1 ~ 45 사이의 숫자가 아닌 경우 예외를 발생시킨다.")
    @Test
    void validateBonusNumberRange() {
        // given
        int bonusNumber = 46;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> WinningInfo.from(winningNumbers, bonusNumber)
        );
    }

    @DisplayName("당첨 번호가 중복된 경우 예외를 발생시킨다.")
    @Test
    void validateDuplicateNumber() {
        // given
        int bonusNumber = 7;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        // when & then
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> WinningInfo.from(winningNumbers, bonusNumber)
        );
    }
}
