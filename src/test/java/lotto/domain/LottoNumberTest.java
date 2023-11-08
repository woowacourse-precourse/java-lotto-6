package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.*;
;

class LottoNumberTest {

    @DisplayName("LottoNumber 정상 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 45, 25})
    void ofTest(int input) {
        assertThatNoException().isThrownBy(() -> LottoNumber.of(input));
    }

    @DisplayName("동등 객체 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 45, 25})
    void equalsTest(int input) {
        LottoNumber lottoNumber1 = LottoNumber.of(input);
        LottoNumber lottoNumber2 = LottoNumber.of(input);

        assertThat(lottoNumber1.equals(lottoNumber2)).isTrue();
    }

    @DisplayName("범위 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    void validateTest(int input) {
        assertThatThrownBy(() -> LottoNumber.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자의 범위는 1이상 45이하여야 합니다");
    }

    @DisplayName("로또 번호들 정상 테스트")
    @ParameterizedTest
    @MethodSource("dataProvider")
    void getLottoNumbersTest(List<Integer> numbers) {
        assertThat(LottoNumber.getLottoNumbers(numbers).size()).isEqualTo(6);
    }

    static Stream<List<Integer>> dataProvider() {
        return Stream.of(
                List.of(4, 2, 3, 1, 5, 6),
                List.of(11, 14, 15, 13, 16, 12)
        );
    }

    @DisplayName("오름차순 정렬 테스트")
    @Test
    void ascendingSortTest() { //오름차순 정렬되어 동등객체 리스트이다
        assertThat(LottoNumber.getLottoNumbers(List.of(4,2,3,1,6,5)))
                .isEqualTo(LottoNumber.getLottoNumbers(List.of(1,2,3,4,5,6)));
    }

}