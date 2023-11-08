package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.util.WinningLottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @DisplayName("범위 밖의 숫자가 존재하면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("generateInvalidLottoNumbers")
    void lottoNumbersOutOfRangeTest(List<Integer> lottoNumbers) {
        assertThatThrownBy(() -> WinningLottoValidator.validateLotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateInvalidLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 46)),
                Arguments.of(List.of(0, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(-3, 4, 5, 6, 7, 8))
        );
    }

    @DisplayName("로또끼리 비교하는 기능 테스트")
    @ParameterizedTest
    @MethodSource("makeTwoLottoWithMatchCount")
    void compareLottoTest(List<Integer> firstLottoNumbers, List<Integer> secondLottoNumbers, int matchCount) {
        Lotto firLotto = new Lotto(firstLottoNumbers);
        Lotto secondLotto = new Lotto(secondLottoNumbers);
        assertThat(firLotto.compare(secondLotto)).isEqualTo(matchCount);
    }

    private static Stream<Arguments> makeTwoLottoWithMatchCount() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 3, 5, 7, 9, 11), 3),
                Arguments.of(List.of(13, 15, 17, 19, 21, 22), List.of(23, 25, 27, 29, 31, 32), 0),
                Arguments.of(List.of(33, 35, 37, 39, 41, 43), List.of(33, 35, 39, 41, 43, 45), 5)
        );
    }

    @DisplayName("로또가 숫자를 가지고 있는지 확인하는 기능 테스트")
    @ParameterizedTest
    @MethodSource("makeArgumentsForIsContainInteger")
    void isContainIntegerTest(List<Integer> lottoNumbers, int containNumber, int notContainNumber) {
        //given
        Lotto lotto = new Lotto(lottoNumbers);
        //when

        //then
        assertThat(lotto.contains(containNumber)).isTrue();
        assertThat(lotto.contains(notContainNumber)).isFalse();
    }

    private static Stream<Arguments> makeArgumentsForIsContainInteger() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 3, 7),
                Arguments.of(List.of(1, 3, 5, 7, 9, 11), 3, 10),
                Arguments.of(List.of(13, 15, 17, 19, 21, 22), 13, 34),
                Arguments.of(List.of(33, 35, 37, 39, 41, 43), 37, 21),
                Arguments.of(List.of(23, 25, 27, 29, 31, 32), 32, 15),
                Arguments.of(List.of(33, 35, 39, 41, 43, 45), 41, 42)
        );
    }
}