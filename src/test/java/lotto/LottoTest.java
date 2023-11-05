package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 존재하는 값을 주면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {5, 7, 11, 4, 1, 36})
    void hasNumberReturnTrue(Integer input) {
        //given
        Lotto lotto = new Lotto(new ArrayList<>(List.of(5, 7, 11, 4, 1, 36)));

        //when
        Boolean hasNumber = lotto.hasNumber(input);

        //then
        assertThat(hasNumber).isTrue();
    }

    @DisplayName("로또 번호에 존재하지 않는 값을 주면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {12, 6, 42, 22, 27, 3})
    void hasNumberReturnFalse(Integer input) {
        //given
        Lotto lotto = new Lotto(new ArrayList<>(List.of(5, 7, 11, 4, 1, 36)));

        //when
        Boolean hasNumber = lotto.hasNumber(input);

        //then
        assertThat(hasNumber).isFalse();
    }


    static Stream<Arguments> createLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(5, 7, 11, 4, 1, 36), 6),
                Arguments.of(Arrays.asList(5, 7, 11, 4, 1, 2), 5),
                Arguments.of(Arrays.asList(5, 7, 11, 4, 22, 2), 4),
                Arguments.of(Arrays.asList(3, 45, 10, 44, 22, 2), 0)
        );
    }

    @DisplayName("주어진 로또와 같은 번호가 있는 수만큼 반환한다.")
    @ParameterizedTest
    @MethodSource("createLottoNumbers")
    void countMatchNumber(List<Integer> lottoNumbers, Integer result) {
        //given
        Lotto lotto = new Lotto(new ArrayList<>(List.of(5, 7, 11, 4, 1, 36)));
        Lotto lotto2 = new Lotto(new ArrayList<>(lottoNumbers));

        //when
        Integer countMatchNumber = lotto.countMatchNumber(lotto2);

        //then
        assertThat(countMatchNumber).isEqualTo(result);
    }
}