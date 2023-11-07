package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import lotto.Lotto;
import lotto.exception.LottoException;
import lotto.exception.LottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[단위 테스트] 로또")
class LottoTest {

    @DisplayName("정상 상황일 때 로또가 생성된다.")
    @Test
    void create_lotto() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertAll(
                () -> assertThatCode(() -> new Lotto(numbers)).doesNotThrowAnyException(),
                () -> assertThat(lotto).isNotNull()
        );
    }

    @DisplayName("로또 숫자의 범위가 1~45가 아니면 예외가 발생한다.")
    @Test
    void throw_exception_when_invalid_range() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoNumberException.INVALID_RANGE.getMessage());
    }

    @DisplayName("중복된 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void throw_exception_when_duplicate() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoException.DUPLICATED_NUMBER.getMessage());
    }

    @DisplayName("로또 크기가 6이 아닐 경우 예외가 발생한다.")
    @Test
    void throw_exception_when_invalid_size() {
        // given
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5);
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 6, 7);

        // when & then
        assertAll(
                () -> assertThatThrownBy(() -> new Lotto(numbers1))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(LottoException.INVALID_SIZE.getMessage()),

                () -> assertThatThrownBy(() -> new Lotto(numbers2))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(LottoException.INVALID_SIZE.getMessage())
        );
    }
}
