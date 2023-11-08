package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @ParameterizedTest
    @MethodSource("generateUnsortedLottoNumber")
    @DisplayName("주어진 당첨 번호는 정렬이 되어야 한다.")
    void isGivenLottoNumberSorted(List<Integer> inputList) {
        Lotto lotto = new Lotto(inputList);
        List<Integer> lottoNumbers = lotto.getNumbers();

        assertThat(lottoNumbers.get(0)).isEqualTo(Collections.min(inputList));
        assertThat(lottoNumbers.get(lottoNumbers.size() - 1)).isEqualTo(Collections.max(inputList));
    }

    static Stream<Arguments> generateUnsortedLottoNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(6, 5, 4, 3, 2, 1)),
                Arguments.of(Arrays.asList(1, 3, 2, 5, 6, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("generateMissRangeLottoNumbers")
    @DisplayName("로또 번호가 0이하, 46이상이면 예외 처리")
    void lottoNumberRangeTest(List<Integer> inputList) {
        assertThatThrownBy(() -> new Lotto(inputList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    static Stream<Arguments> generateMissRangeLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(-10, -5, -3, -2, -1, 0)),
                Arguments.of(Arrays.asList(46, 50, 55, 60, 90, 100)),
                Arguments.of(Arrays.asList(-1, 0, 13, 23, 49, 77))
        );
    }

    @ParameterizedTest
    @MethodSource("generateWrongSizeOfLottoNumbers")
    @DisplayName("당첨 번호 길이가 6이 아니면 예외 처리")
    void lottoNumberListRangeTest(List<Integer> inputList) {
        assertThatThrownBy(() -> new Lotto(inputList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호의 길이는 6이어야 합니다.");
    }

    static Stream<Arguments> generateWrongSizeOfLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9))
        );
    }

    @ParameterizedTest
    @MethodSource("generateDuplicatedLottoNumbers")
    @DisplayName("당첨 번호에 중복값이 존재할 경우 예외 처리")
    void lottoNumberDuplicatedTest(List<Integer> inputList) {
        assertThatThrownBy(() -> new Lotto(inputList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호중 중복된 숫자가 존재합니다.");
    }

    static Stream<Arguments> generateDuplicatedLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 1, 1, 1, 1, 1)),
                Arguments.of(Arrays.asList(1, 1, 2, 2, 3, 3))
        );
    }

}
