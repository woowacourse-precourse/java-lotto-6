package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.LottoExceptionMessage;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
        @ValueSource(strings = {"1", "1,2", "1,2,3", "11,12,13,14", "23,24,26,27,29", "22,22,22,21,10",
                "1,2,3,4,5,6,7,9,10"})
        @DisplayName("[Exception - Invalid Count] 로또 번호의 개수가 6개가 아니면 예외 발생")
        void outOfRange(String input) {
            List<Integer> inValidCountNumbers = createLottoNumbers(input);
            assertThatThrownBy(() -> new Lotto(inValidCountNumbers))
                    .hasMessage(LottoExceptionMessage.NOT_SATISFY_REQUIRED_COUNT.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,23,35,44,27,1", "45,1,2,3,45,7"})
        @DisplayName("[Exception - duplicate] 로또 번호가 중복이면 예외 발생")
        void duplicate(String input) {
            List<Integer> duplicateNumbers = createLottoNumbers(input);
            assertThatThrownBy(() -> new Lotto(duplicateNumbers))
                    .hasMessage(LottoExceptionMessage.DUPLICATE_EXISTS.getError());
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,21,32,14,23,46", "0,1,5,4,3,2", "-1,1,2,3,4,5", "2147483647,7,6,5,4,3"})
        @DisplayName("[Exception - Invalid Number] 유효하지 않는 로또 번호면 Lotto 에서 예외 발생")
        void invalidLottNumber(String input) {
            List<Integer> invalidNumbers = createLottoNumbers(input);
            assertThatThrownBy(() -> new Lotto(invalidNumbers))
                    .hasMessage(LottoExceptionMessage.INVALID_NUMBER.getError());
        }
    }

    private List<Integer> createLottoNumbers(String input) {
        List<Integer> lottoNumbers = Lists.newArrayList(input.split(","))
                .stream()
                .map(Integer::parseInt)
                .toList();
        return lottoNumbers;
    }
}