package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Lotto 클래스")
class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성 테스트")
    @Test
    void testCreateLotto() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @DisplayName("로또 일치하는 번호 수 계산 테스트")
    @Test
    void calculateMatchCount() {
        // given
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto matched = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        // when
        int count = target.match(matched);

        // then
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("로또 번호 포함 여부 확인 테스트")
    @Test
    void containsNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // then
        assertThat(lotto.contains(3)).isTrue();
        assertThat(lotto.contains(7)).isFalse();
    }

    @DisplayName("로또 생성 예외 테스트")
    @Nested
    class CreateLottoExceptionTest {
        @DisplayName("로또 번호 개수 예외 테스트")
        @Test
        void testWrongLottoNumbersCount() {
            // given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5);

            // then
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(new InvalidInputException(ErrorMessage.WRONG_LOTTO_NUMBERS_COUNT).getMessage());
        }

        @DisplayName("로또 번호 범위 예외 테스트 - 미만")
        @Test
        void testLottoNumberOver() {
            // given
            List<Integer> numbers = List.of(0, 2, 3, 4, 5, 6);

            // then
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(new InvalidInputException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE).getMessage());

        }

        @DisplayName("로또 번호 범위 예외 테스트 - 초과")
        @Test
        void testLottoNumberUnder() {
            // given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

            // then
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(new InvalidInputException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE).getMessage());
        }

        @DisplayName("로또 번호 중복 예외 테스트")
        @Test
        void testLottoNumbersDuplicate() {
            // given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);

            // then
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(new InvalidInputException(ErrorMessage.LOTTO_NUMBERS_DUPLICATE).getMessage());
        }
    }
}
