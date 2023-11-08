package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.Constants;

class LottoTest {

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @MethodSource("provideOutOfRangeNumbers")
    @DisplayName("로또 번호 예외 처리: 1 ~ 45 범위를 벗어난 경우")
    void givenOutOfRangeNumbers_whenCreateLotto_then(List<Integer> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers))
                .withMessageStartingWith(Constants.ERROR_MESSAGE)
                .withMessageContaining("로또 번호는 1 ~ 45 숫자만 가능합니다.");
    }

    private static Stream<Arguments> provideOutOfRangeNumbers() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 2, 3, 4, 45)),
                Arguments.of(List.of(1, 2, 3, 4, 45, 46))
        );
    }

    @Test
    @DisplayName("로또 생성 성공: 로또 번호는 정렬된 상태로 저장된다")
    void givenNumbers_whenCreateLotto_thenReturnSortedNumbers() {
        // given
        List<Integer> numbers = List.of(6, 5, 4, 3, 2, 1);

        // when
        Lotto result = new Lotto(numbers);

        // then
        assertThat(result.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또 번호는 오름차순으로 정렬된 상태로 저장한다")
    void givenUnsortedNumbers_whenCreateLotto_thenShouldSortedNumbers() {
        // given
        List<Integer> unsortedNumbers = List.of(6, 1, 4, 2, 3, 5);

        // when
        Lotto lotto = new Lotto(unsortedNumbers);

        // then
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest(name = "입력값 : {0}, 기대값 : {1}")
    @MethodSource("provideDataForCompare")
    @DisplayName("두 개의 로또를 비교해 매칭된 번호 개수를 알려준다")
    void givenTwoLotto_whenCompare_thenReturnMatchingCount(List<Integer> numbers, int expected) {
        // given
        Lotto fixedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);

        // when
        int result = fixedLotto.compare(lotto);

        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideDataForCompare() {
        return Stream.of(
                Arguments.of(List.of(1, 7, 8, 9, 10, 11), 1),
                Arguments.of(List.of(1, 2, 8, 9, 10, 11), 2),
                Arguments.of(List.of(1, 2, 3, 9, 10, 11), 3),
                Arguments.of(List.of(1, 2, 3, 4, 10, 11), 4),
                Arguments.of(List.of(1, 2, 3, 4, 5, 11), 5),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
    @DisplayName("로또가 해당 번호를 갖고 있는지 알려준다")
    void givenLottoAndNumber_whenHasNumber_thenReturnTrueOrFalse(int number, boolean expected) {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean result = lotto.hasNumber(number);

        // then
        assertThat(result).isEqualTo(expected);
    }

}
