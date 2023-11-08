package lotto.domain;

import lotto.dto.LottoNumbersDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @ParameterizedTest
    @MethodSource("generateData")
    void Lotto_객체_생성(List<Integer> input) {
        assertThat(new Lotto(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {46, 47, 50, 1_000})
    void 로또_번호가_허용범위를_넘어가면_예외가_발생한다(int input) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 46까지 입력하실 수 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -50, -1_000})
    void 로또_번호가_최소허용_범위보다_작으면_예외가_발생한다(int input) {
        assertThatThrownBy(() -> new Lotto(List.of(input, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1이상부터 입력하실 수 있습니다.");
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void 로또_번호에_해당번호가_있으면_true를_반환한다(List<Integer> input, int index) {
        var expected = List.of(1, 16, 23, 31);
        assertThat(new Lotto(input).contains(expected.get(index)))
                .isTrue();
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void 로또_번호에_해당번호가_없으면_false를_반환한다(List<Integer> input, int index) {
        var expected = List.of(7, 6, 10, 45);
        assertThat(new Lotto(input).contains(expected.get(index)))
                .isFalse();
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void toDTO를_통해_LottoNumbersDTO를_생성한다(List<Integer> input, int index) {
        var expected = List.of(
                new LottoNumbersDTO(List.of("1", "2", "3", "4", "5", "6")),
                new LottoNumbersDTO(List.of("11", "12", "13", "14", "15", "16")),
                new LottoNumbersDTO(List.of("21", "22", "23", "24", "25", "26")),
                new LottoNumbersDTO(List.of("31", "32", "33", "34", "35", "36"))
        );
        assertThat(new Lotto(input).toDTO())
                .isEqualTo(expected.get(index));
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void getNumbers를_통해_로또번호를_반환한다(List<Integer> input, int index) {
        var expected = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(11, 12, 13, 14, 15, 16),
                List.of(21, 22, 23, 24, 25, 26),
                List.of(31, 32, 33, 34, 35, 36)
        );
        assertThat(new Lotto(input).getNumbers())
                .isEqualTo(expected.get(index));
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 0),
                Arguments.of(List.of(11, 12, 13, 14, 15, 16), 1),
                Arguments.of(List.of(21, 22, 23, 24, 25, 26), 2),
                Arguments.of(List.of(31, 32, 33, 34, 35, 36), 3)
        );
    }
}
