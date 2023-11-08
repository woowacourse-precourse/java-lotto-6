package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

public class WinningNumbersTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Nested
    @DisplayName("WinningNumbers 생성 테스트")
    class CreateWinningNumbersTests {

        @Test
        @DisplayName("정상적인 당첨 번호와 보너스 번호")
        void createWinningNumbers_Valid() {
            // 준비
            List<Integer> numbers = Arrays.asList(3, 11, 21, 29, 38, 42);
            int bonus = 9;

            // 실행
            WinningNumbers winningNumbers = WinningNumbers.of(numbers, bonus);

            // 검증
            assertThat(winningNumbers).isNotNull();
            assertThat(winningNumbers.getNumbers()).containsExactlyElementsOf(numbers);
            assertThat(winningNumbers.getBonus()).isEqualTo(bonus);
        }

        @Test
        @DisplayName("당첨 번호에 보너스 번호가 포함되어 있는 경우")
        void createWinningNumbers_BonusNumberIncludedInNumbers() {
            // 준비
            List<Integer> numbers = Arrays.asList(3, 11, 21, 29, 38, 42);
            int bonus = 21; // numbers에 포함되어 있음

            // 실행 & 검증
            assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbers.of(numbers, bonus))
                    .withMessageContaining(ERROR_MESSAGE);
        }

        // 경계값 분석 테스트
        @ParameterizedTest
        @ValueSource(ints = {0, 46}) // 로또 번호는 1~45 사이어야 함
        @DisplayName("당첨 번호에 유효하지 않은 숫자가 포함된 경우 예외 발생")
        void createWinningNumbers_InvalidNumbers_ThrowsException(int invalidNumber) {
            // 준비
            List<Integer> numbers = Arrays.asList(3, 11, 21, 29, 38, invalidNumber); // 잘못된 값 포함

            // 실행 & 검증
            assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbers.of(numbers, 9))
                    .withMessageContaining(ERROR_MESSAGE);
        }

        @Test
        @DisplayName("당첨 번호가 6개가 아닌 경우 예외 발생")
        void createWinningNumbers_IncorrectSize_ThrowsException() {
            // 준비
            List<Integer> numbers = Arrays.asList(3, 11, 21, 29); // 번호가 4개뿐임

            // 실행 & 검증
            assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbers.of(numbers, 9))
                    .withMessageContaining(ERROR_MESSAGE);
        }

        // 동치 분할 테스트
        @Test
        @DisplayName("모든 당첨 번호가 같은 경우 예외 발생")
        void createWinningNumbers_AllSameNumbers_ThrowsException() {
            // 준비
            List<Integer> numbers = Arrays.asList(7, 7, 7, 7, 7, 7); // 모든 번호가 같음

            // 실행 & 검증
            assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbers.of(numbers, 9))
                    .withMessageContaining(ERROR_MESSAGE);
        }

        // 프로퍼티 기반 테스트
        @Test
        @DisplayName("당첨 번호 순서를 바꾸어도 동일한 객체가 생성되어야 함")
        void createWinningNumbers_DifferentOrder_SameObject() {
            // 준비
            List<Integer> numbers = Arrays.asList(3, 11, 21, 29, 38, 42);
            List<Integer> shuffledNumbers = Arrays.asList(42, 38, 29, 21, 11, 3);
            int bonus = 9;

            // 실행
            WinningNumbers winningNumbers1 = WinningNumbers.of(numbers, bonus);
            WinningNumbers winningNumbers2 = WinningNumbers.of(shuffledNumbers, bonus);

            // 검증
            assertThat(winningNumbers1.getNumbers()).containsExactlyInAnyOrderElementsOf(winningNumbers2.getNumbers());
            assertThat(winningNumbers1.getBonus()).isEqualTo(winningNumbers2.getBonus());
        }

        // 파라미터화 테스트
        @ParameterizedTest
        @CsvSource({
                "1, 2, 3, 4, 5, 6, 7",
                "8, 9, 10, 11, 12, 13, 14",
                "15, 16, 17, 18, 19, 20, 21",
                "22, 23, 24, 25, 26, 27, 28",
                "29, 30, 31, 32, 33, 34, 35",
                "36, 37, 38, 39, 40, 41, 42"
        })
        @DisplayName("유효한 당첨 번호와 보너스 번호로 WinningNumbers 객체 생성")
        void createWinningNumbers_ValidInput_CreatesObject(int n1, int n2, int n3, int n4, int n5, int n6, int bonus) {
            // 준비
            List<Integer> numbers = Arrays.asList(n1, n2, n3, n4, n5, n6);

            // 실행
            WinningNumbers winningNumbers = WinningNumbers.of(numbers, bonus);

            // 검증
            assertThat(winningNumbers.getNumbers()).containsExactlyInAnyOrder(n1, n2, n3, n4, n5, n6);
            assertThat(winningNumbers.getBonus()).isEqualTo(bonus);
        }

    }
}