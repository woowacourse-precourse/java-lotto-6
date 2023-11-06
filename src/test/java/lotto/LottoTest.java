package lotto;

import static lotto.error.ErrorMessage.NOT_IN_BOUND_LOTTO_NUMBERS;
import static lotto.error.ErrorMessage.NOT_SIX_LOTTO_NUMBERS;
import static lotto.error.ErrorMessage.NOT_UNIQUE_LOTTO_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // When & Then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_SIX_LOTTO_NUMBERS.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // Given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // When & Then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_UNIQUE_LOTTO_NUMBERS.getMessage());
    }

    @Test
    @DisplayName("로또 번호에 1 ~ 45 범위가 아닌 숫자가 있으면 예외가 발생한다.")
    void createLottoByNotInBoundNumber() {
        // Given
        List<Integer> numbers = List.of(-1, 1, 2, 46, 45, 22);

        // When & Then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_IN_BOUND_LOTTO_NUMBERS.getMessage());
    }

    @Test
    @DisplayName("로또 번호는 오름차순 정렬되어 있다.")
    void createLotto_SortedNumbers() {
        // Given
        List<Integer> numbers = List.of(45, 23, 41, 2, 14, 25);
        List<Integer> expected = List.of(2, 14, 23, 25, 41, 45);

        // When
        Lotto result = new Lotto(numbers);

        // Then
        assertThat(result.getNumbers()).isEqualTo(expected);
    }
}