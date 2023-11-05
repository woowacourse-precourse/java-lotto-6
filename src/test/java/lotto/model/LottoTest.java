package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.common.exception.ErrorMessage;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @Nested
    class 로또_생성 {

        static Stream<Arguments> getSuccessArgument() {
            return Stream.of(
                    Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    Arguments.of(Arrays.asList(10, 5, 7, 3, 2, 1))
            );
        }

        @MethodSource("getSuccessArgument")
        @ParameterizedTest
        void 로또가_성공적으로_오름차순정렬되어_생성된다(List<Integer> numbers) {
            //given
            //when
            Lotto lotto = new Lotto(numbers);
            //then
            numbers.sort(Integer::compareTo);
            assertThat(lotto.getNumbers()).hasSize(6)
                    .containsExactlyElementsOf(numbers);
        }

        @Test
        void 로또번호개수가_6개가_넘으면_예외가_발생한다() {
            //given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
            //when then
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_LOTTO_NUMBERS_SIZE.getValue());
        }

        @Test
        void 로또번호에_중복이_있다면_예외가_발생한다() {
            //given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 5);
            //when then
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.DUPLICATED_NUMBER.getValue());
        }

        @Test
        void 로또번호가_1부터_45사이가_아니라면_예외가_발생한다() {
            //given
            List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
            //when then
            assertThatThrownBy(() -> new Lotto(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getValue());
        }
    }
}