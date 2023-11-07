package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoNumbersTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복된 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("duplicateBonusNumberInfo")
    void createWinningLottoNumbersByDuplicateBonusNumber(List<Integer> numbers, int bonusNumber) {
        Lotto lotto = new Lotto(numbers);
        assertThatThrownBy(() -> new WinningLottoNumbers(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static List<Arguments> duplicateBonusNumberInfo() {
        return Arrays.asList(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 1),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 2),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 3)
        );
    }

    @DisplayName("보너스 번호 숫자 범위가 1~45가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("invalidNumberRangeBonusNumberInfo")
    void createWinningLottoNumbersByInvalidNumberRangeBonusNumber(List<Integer> numbers, int bonusNumber) {
        Lotto lotto = new Lotto(numbers);
        assertThatThrownBy(() -> new WinningLottoNumbers(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static List<Arguments> invalidNumberRangeBonusNumberInfo() {
        return Arrays.asList(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), -1),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 0),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 46)
        );
    }

    @DisplayName("로또 번호와 보너스 번호가 올바른 형식인 경우 성공한다.")
    @Test
    void createWinningLottoNumbersByValidNumbersTest() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumbers, bonusNumber);

        assertThat(winningLottoNumbers.getWinningNumbers()).isEqualTo(winningLottoNumbers.getWinningNumbers());
        assertThat(winningLottoNumbers.getBonusNumber()).isEqualTo(bonusNumber);
    }
}