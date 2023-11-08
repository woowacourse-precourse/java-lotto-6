package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.utils.message.LottoExceptionMessage;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Nested
    @DisplayName("유효성 테스트")
    class ValidationTest {
        @Test
        @DisplayName("[Exception - Edge] 로또 번호의 개수가 5개면 예외 발생")
        void upperBound() {
            assertThatThrownBy(() -> new Lotto(List.of(7, 16, 24, 1, 45)))
                    .hasMessage(LottoExceptionMessage.NOT_SATISFY_REQUIRED_COUNT.getError());
        }

        @Test
        @DisplayName("[Exception - Edge] 로또 번호의 개수가 7개면 예외 발생")
        void lowerBound() {
            assertThatThrownBy(() -> new Lotto(List.of(7, 16, 24, 1, 45, 2, 3)))
                    .hasMessage(LottoExceptionMessage.NOT_SATISFY_REQUIRED_COUNT.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "1,2", "1,2,3", "11,12,13,14", "23,24,26,27,29",
                "22,22,22,21,10", "1,2,3,4,5,6,7,9,10", "1,2,3,4,5,23,7", "11,12,13,45,15,8,4",
                "31,32,33,34", "34,35,36", "39,38,23,24,25"})
        @DisplayName("[Exception - Invalid Count] 로또 번호의 개수가 6개가 아니면 예외 발생")
        void outOfRange(String input) {
            List<Integer> inValidCountNumbers = createLottoNumbers(input);
            assertThatThrownBy(() -> new Lotto(inValidCountNumbers))
                    .hasMessage(LottoExceptionMessage.NOT_SATISFY_REQUIRED_COUNT.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,23,7", "11,12,13,45,15,8,4", "31,32,33,34", "1", "1,2", "34,35,36",
                "39,38,23,24,25"})
        @DisplayName("[Exception] 번호가 6개가 아니면 예외가 발생한다.")
        void invalidCount(String wrongInput) {
            List<Integer> inValidCountNumbers = createLottoNumbers(wrongInput);
            Assertions.assertThatThrownBy(() -> new Lotto(inValidCountNumbers))
                    .hasMessage(LottoExceptionMessage.NOT_SATISFY_REQUIRED_COUNT.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,23,35,44,27,1", "45,1,2,3,45,7", "1,2,3,4,5,1", "11,12,13,45,15,45", "4,1,2,3,4,5"})
        @DisplayName("[Exception - duplicate] 로또 번호가 중복이면 예외 발생")
        void duplicate(String input) {
            List<Integer> duplicateNumbers = createLottoNumbers(input);
            assertThatThrownBy(() -> new Lotto(duplicateNumbers))
                    .hasMessage(LottoExceptionMessage.NOT_SATISFY_LOTTO_NUMBER_UNIQUE.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,21,32,14,23,46", "0,1,5,4,3,2", "-1,1,2,3,4,5", "2147483647,7,6,5,4,3",
                "1,2,3,4,5,0", "11,12,13,46,15,16", "12345678,1,2,3,4,5"})
        @DisplayName("[Exception - Invalid Number] 각 번호의 범위가 1 ~ 45가 아니면 예외가 발생한다.")
        void invalidLottNumber(String input) {
            List<Integer> invalidNumbers = createLottoNumbers(input);
            assertThatThrownBy(() -> new Lotto(invalidNumbers))
                    .hasMessage(LottoExceptionMessage.NOT_SATISFY_LOTTO_NUMBER_RANGE.getError());
        }
    }

    @Nested
    @DisplayName("로또 번호 포함 개수 기능 테스트")
    class CalculateContainCountsTest {

        private final Lotto playerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        @ParameterizedTest
        @CsvSource(value = {
                "7,8,9,10,11,1:1",
                "12,13,14,15,3,6:2",
                "17,18,19,2,5,4:3",
                "20,25,1,3,5,6:4",
                "31,1,3,4,6,5:5",
                "3,5,1,4,2,6:6"},
                delimiter = ':')
        @DisplayName("당첨 번호와 기댓값이 주어졌을 때, 일치하는지 확인")
        void oneContainCount(String winnerNumbers, int expectedCounts) {
            // given
            Lotto winningNumber = new Lotto(createLottoNumbers(winnerNumbers));
            Assertions.assertThat(playerLotto.countMatchingNumbers(winningNumber))
                    .isSameAs(expectedCounts);
        }
    }

    @Nested
    @DisplayName("로또 번호를 포함하는지 확인하는 기능 테스트")
    class IsContainsTest {
        @ParameterizedTest
        @ValueSource(ints = {1, 45, 35, 27, 16, 23})
        @DisplayName("Lotto에 LottoNumber가 포함되는 경우")
        void isContainsTest(int lottoNumberInput) {
            // given
            Lotto lotto = new Lotto(List.of(1, 45, 35, 27, 16, 23));
            LottoNumber lottoNumber = new LottoNumber(lottoNumberInput);
            // when
            boolean contains = lotto.isContains(lottoNumber);
            // then
            Assertions.assertThat(contains).isTrue();
        }

        @ParameterizedTest
        @ValueSource(ints = {21, 24, 1, 45, 8, 4, 3, 34, 37})
        @DisplayName("Lotto에 LottoNumber가 포함되지 않는 경우")
        void isNotContainsTest(int lottoNumberInput) {
            // given
            Lotto lotto = new Lotto(List.of(22, 23, 11, 7, 5, 6));
            LottoNumber lottoNumber = new LottoNumber(lottoNumberInput);
            // when
            boolean contains = lotto.isContains(lottoNumber);
            // then
            Assertions.assertThat(contains).isFalse();
        }
    }

    private List<Integer> createLottoNumbers(String input) {
        return Lists.newArrayList(input.split(","))
                .stream()
                .map(Integer::parseInt)
                .toList();
    }
}