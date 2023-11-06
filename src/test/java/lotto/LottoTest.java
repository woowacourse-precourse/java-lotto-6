package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.lotto.LottoErrorMessage.INVALID_RANGE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;


class LottoTest {

    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 번호는 1에서 45사이의 값이어야 한다.")
    @ParameterizedTest
    @MethodSource("provideInvalidRangeNumbers")
    void createInvalidRange(List<Integer> numbers) {

        //when, then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_RANGE_ERROR.getMessage());
    }

    @Test
    void 유효_로또_번호_생성() {
        //given
        List<Integer> lottoNumber = lottoNumberGenerator.generate();

        //when,then
        assertThatCode(() -> new Lotto(lottoNumber))
                .doesNotThrowAnyException();
    }

    @Test
    void 로또_번호는_오름차순() {
        //given
        List<Integer> lottoNumber = lottoNumberGenerator.generate();

        //when
        List<Integer> clone = lottoNumber.stream()
                .sorted()
                .toList();

        //then
        assertThat(lottoNumber).isEqualTo(clone);
    }

    private static Stream<Arguments> provideInvalidRangeNumbers() {
        return Stream.of(
                Arguments.of(List.of(0,1,2,3,4,5)),
                Arguments.of(List.of(41,42,43,44,45,46)),
                Arguments.of(List.of(0,10,20,30,40,50))
        );
    }
}