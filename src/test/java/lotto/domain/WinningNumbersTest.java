package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("당첨 번호의 보너스 번호가 이미 부른 번호면 예외를 발생한다.")
    public void validateDuplicateBonusNumber(int number) {
        // given
        Lotto lotto = new Lotto(
                IntStream.rangeClosed(1, 6)
                        .mapToObj(LottoBall::new)
                        .toList()
        );

        LottoBall bonusBall = new LottoBall(number);

        // when, then
        assertThatThrownBy(() -> new WinningNumbers(lotto, bonusBall))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 8, 44, 45})
    @DisplayName("당첨 번호의 보너스 번호를 부르지 않았다면 정상적으로 진행한다.")
    public void validateDistinctBonusNumber(int number) {
        // given
        Lotto lotto = new Lotto(
                IntStream.rangeClosed(1, 6)
                        .mapToObj(LottoBall::new)
                        .toList()
        );

        LottoBall bonusBall = new LottoBall(number);

        // when, then
        assertDoesNotThrow(() -> new WinningNumbers(lotto, bonusBall));

    }
}