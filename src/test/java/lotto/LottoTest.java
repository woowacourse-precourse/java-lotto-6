package lotto;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.enums.Constant;
import lotto.enums.ErrorMessage;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(givenNumbers(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_OF_LOTTO_NUMBERS_IS_6.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(givenNumbers(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBERS_HAS_NO_DUPLICATE.getMessage());
    }

    @ParameterizedTest(name = "대상 : {0}")
    @MethodSource("lottoNumbersOverRange")
    @DisplayName("로또 번호가 1 ~ 45 범위 안에 없다면 예외가 발생한다.")
    void createLottoByOverRangeNumber(List<Integer> test) {
        assertThatThrownBy(() -> new Lotto(test))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(
                        ErrorMessage.LOTTO_NUMBERS_HAS_RANGE.getMessage(),
                        Constant.START_RANGE_OF_NUMBER.getContentToInteger(),
                        Constant.END_RANGE_OF_NUMBER.getContentToInteger()
                ));
    }

    static Stream<Arguments> lottoNumbersOverRange() {
        return Stream.of(
                Arguments.arguments(givenNumbers(0, 1, 2, 3, 4, 5)), // 0이 존재한는 경우
                Arguments.arguments(givenNumbers(-2, 1, 2, 3, 4, 5)), // 음수가 존재하는 경우
                Arguments.arguments(givenNumbers(1, 2, 3, 4, 5, 56)) // 45를 벗어난 경우
        );
    }

    @DisplayName("임의의 번호와 생성된 로또 번호는 비교될 수 있어야 합니다.")
    @Test
    void compareLottoByAnyNumber() {
        List<Integer> targetNumbers = List.of(2, 10, 5, 45);
        List<Boolean> expectedResult = List.of(true, false, true, false);
        Lotto lotto = new Lotto(givenNumbers(1, 2, 3, 4, 5, 6));

        for (int i = 0; i < targetNumbers.size(); ++i) {
            assertThat(lotto.isMatch(targetNumbers.get(i))).isEqualTo(expectedResult.get(i));
        }
    }


    @ParameterizedTest(name = "생성 : {0}, 대상 : {1}, 예상 개수 : {2}")
    @MethodSource("lottoNumbersAndGivenLottoNumbers")
    @DisplayName("임의의 로또와 생성된 로또는 일치하는 개수를 셀 수 있어야 합니다.")
    void countMatchesByGivenLotto(Lotto lotto, Lotto givenLotto, Integer expected) {
        assertThat(lotto.countMatchesNumber(givenLotto)).isEqualTo(expected);
    }

    static Stream<Arguments> lottoNumbersAndGivenLottoNumbers() {
        return Stream.of(
                Arguments.arguments(
                        new Lotto(givenNumbers(1, 2, 3, 4, 5, 6)),
                        new Lotto(givenNumbers(4, 5, 6, 7, 8, 9)),
                        3
                ),
                Arguments.arguments(
                        new Lotto(givenNumbers(1, 2, 3, 4, 5, 6)),
                        new Lotto(givenNumbers(7, 8, 9, 10, 11, 12)),
                        0
                ),
                Arguments.arguments(
                        new Lotto(givenNumbers(1, 2, 3, 4, 5, 6)),
                        new Lotto(givenNumbers(1, 2, 3, 4, 5, 6)),
                        6
                )
        );
    }

    @DisplayName("저장된 로또 번호는 정해진 형식으로 출력됩니다.")
    @Test
    void convertStringByLotto() {
        Lotto lotto = new Lotto(givenNumbers(1, 2, 3, 4, 5, 6));

        String result = lotto.toString();

        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    private static List<Integer> givenNumbers(Integer... numbers) {
        return Arrays.stream(numbers)
                .collect(Collectors.toList());
    }
}