package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    @DisplayName("로또 번호가 올바르게 생성되는지 테스트")
    void createLottoWithCorrectNumbers() {
        // Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // When
        Lotto lotto = new Lotto(numbers);

        // Then
        assertThat(lotto.getNumbers()).containsExactlyInAnyOrderElementsOf(numbers);
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닐 경우 예외를 던지는지 테스트")
    void throwExceptionWhenNumbersSizeIsNotSix() {
        // Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개만 가능합니다.");
    }

    @Test
    @DisplayName("로또 번호에 중복이 있을 경우 예외를 던지는지 테스트")
    void throwExceptionWhenNumbersAreDuplicated() {
        // Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        // Then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 로또 번호가 있습니다.");
    }

    @Test
    @DisplayName("로또 번호가 범위를 벗어날 경우 예외를 던지는지 테스트")
    void throwExceptionWhenNumbersAreOutOfBound() {
        // Given
        List<Integer> numbers = Arrays.asList(0, 2, 3, 4, 5, 46);

        // Then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 숫자 범위는 1 ~ 45 입니다.");
    }
}
