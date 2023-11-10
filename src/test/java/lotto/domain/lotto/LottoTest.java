package lotto.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.config.GameConfig.*;
import static lotto.exception.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("LottoTest")
class LottoTest {

    @Test
    @DisplayName("정해진 길이가 아닌 숫자 리스트로 로또를 생성하였을 때 예외를 반환한다.")
    void when_lotto_numbers_length_invalid_create_fail() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when, then
        assertThatThrownBy(() -> Lotto.create(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(
                        LOTTO_NUMBERS_INPUT_LENGTH_INVALID.getMessage(),
                        LOTTO_NUMBERS_LENGTH.getNumber())
                );
    }

    @Test
    @DisplayName("중복된 원소가 있는 숫자 리스트로 로또를 생성하였을 때 예외를 반환한다.")
    void when_lotto_numbers_duplicated_invalid_create_fail() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // when, then
        assertThatThrownBy(() -> Lotto.create(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_NUMBERS_DUPLICATED.getMessage());
    }

    @Test
    @DisplayName("로또 인스턴스가 주어졌을 때 로또숫자 타입 리스트를 정수 타입 리스트로 변환한다.")
    void getIntegerNumbers() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.create(numbers);

        // when
        List<Integer> getIntegerNumber = lotto.getIntegerNumbers();

        // then
        Assertions.assertThat(getIntegerNumber).isEqualTo(numbers);
    }
}