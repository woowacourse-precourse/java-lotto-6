package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

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

    @Test
    @DisplayName("숫자 일치 테스트")
    void matchingNumbersTest() {
        List<Integer> winningNumber = List.of(1, 2, 3, 7, 8, 9);

        assertMatchingNumbers(winningNumber, 3);
        winningNumber = List.of(1, 2, 3, 4, 8, 9);
        assertMatchingNumbers(winningNumber, 4);
        winningNumber = List.of(1, 2, 3, 4, 5, 9);
        assertMatchingNumbers(winningNumber, 5);
        winningNumber = List.of(1, 2, 3, 4, 5, 10);
        assertMatchingNumbers(winningNumber, 5);
        winningNumber = List.of(1, 2, 3, 4, 5, 6);
        assertMatchingNumbers(winningNumber, 6);
    }

    private void assertMatchingNumbers(List<Integer> winningNumber, int expectedCount) {
        int count = lotto.matchingCount(winningNumber);
        assertThat(expectedCount).isEqualTo(count);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 일치하는 갯수 테스트")
    void calculateMatchingNumbersTest() {
        List<Integer> numbers = List.of(1, 2, 3, 10, 20, 30);
        int actual = lotto.matchingCount(numbers);
        int expected = 3;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("3개 일치하는 경우 테스트")
    void matchingNumberSetTest() {
        List<Integer> numbers = List.of(0, 0, 0, 1, 0, 0, 0);
        int bonus = 10;
        int count = 3;
        List<Integer> actual = lotto.calculateMatchingNumbers(bonus, count);
        assertThat(actual).isEqualTo(numbers);
    }

    @Test
    @DisplayName("5개 + 보너스 번호 일치 테스트")
    void matchingNumberSetBonusTest() {
        //
        List<Integer> numbers = List.of(1, 0, 0, 0, 0, 0, 0);
        int bonus = 6;
        int count = 5;
        List<Integer> actual = lotto.calculateMatchingNumbers(bonus, count);
        assertThat(actual).isEqualTo(numbers);
    }

    @Test
    @DisplayName("번호가 일치하지 않는 경우 테스트")
    void matchingNumberSet6Test() {
        List<Integer> numbers = List.of(0, 0, 0, 0, 0, 0, 0);
        int bonus = 6;
        int count = 0;
        List<Integer> actual = lotto.calculateMatchingNumbers(bonus, count);
        assertThat(actual).isEqualTo(numbers);
    }

    @DisplayName("일치하는 개수에 따라 count값이 오르는지 테스트")
    @ParameterizedTest
    @CsvSource({
            "11, 12, 13, 14, 15, 16, 0", // count = 0
            "1, 11, 12, 13, 14, 15, 1", // count = 1
            "1, 2, 11, 12, 13, 14, 2",  // count = 2
            "1, 2, 3, 11, 12, 13, 3",   // count = 3
            "1, 2, 3, 4, 11, 12, 4",    // count = 4
            "1, 2, 3, 4, 5, 11, 5",     // count = 5
            "1, 2, 3, 4, 5, 6, 6"       // count = 6
    })
    void matchingCountTest(int num1, int num2, int num3, int num4, int num5, int num6, int expected) {
        List<Integer> winningNumber = List.of(num1, num2, num3, num4, num5, num6);
        int count = lotto.matchingCount(winningNumber);

        assertThat(count).isEqualTo(expected);
    }
}