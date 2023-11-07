package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("당첨 번호와 일치하는 개수를 구하는 기능 테스트")
    @Test
    void countMatchingNumbers() {
        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        int expected = 5;

        int matchingNumbers = winningLotto.countMatchingNumbers(lotto);

        assertThat(matchingNumbers).isEqualTo(expected);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복할 때 예외처리 테스트")
    @Test
    void validateDuplicationThrowsException() {
        assertThatThrownBy(() -> WinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복하지 않을 때 예외처리 테스트")
    @Test
    void validateDuplicationDoesNotThrowsException() {
        assertThatCode(() -> WinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7))
                .doesNotThrowAnyException();
    }
}