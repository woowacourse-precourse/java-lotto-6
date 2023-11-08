package lotto;

import java.util.HashSet;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @DisplayName("로또 번호 자동 생성시 1 ~ 45 범위의 서로 다른 6개의 번호를 생성한다.")
    @RepeatedTest(10)
    void checkGeneratedLottoNumbers() {
        List<Integer> numbers = Lotto.generateLottoNumbers();
        assertEquals(6, numbers.size());
        assertEquals(6, new HashSet(numbers).size());
        assertTrue(numbers.stream().allMatch(n -> n <= 45 && n >= 1));
    }

    @DisplayName("로또 발급시 잘못된 입력을 예외 처리한다.")
    @ParameterizedTest
    @MethodSource("provideInvalidInitializationParams")
    void testExceptionOnInvalidInitialization(List<Integer> numbers) {
        assertThatThrownBy(() -> {
            new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    static Stream<Arguments> provideInvalidInitializationParams() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,6,7)),
                Arguments.of(List.of(1,2,3,4,5,50)),
                Arguments.of(List.of(1,2,3,4,5,5))
        );
    }

    @DisplayName("Lotto의 numbers와 주어진 숫자들의 일치하는 숫자를 센다.")
    @ParameterizedTest
    @MethodSource("provideTestLotto")
    void checkLottoMatch(List<Integer> testTickets, int expected) {
        // TODO: refactor
        Lotto testLotto = new Lotto(List.of(5, 10, 15, 20, 25, 30));

        int actual = testLotto.countMatchingNumbers(testTickets);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> provideTestLotto() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 1),
                Arguments.of(List.of(23, 12, 22, 33, 14, 7), 0),
                Arguments.of(List.of(30, 25, 20, 15, 5, 10), 6),
                Arguments.of(List.of(1,23,5,10,2,45), 2)
        );
    }

    @DisplayName("Lotto의 number에 해당 숫자가 포함되어 있는지 판단")
    @ParameterizedTest
    @MethodSource("provideTestNumber")
    void checkNumberMatch(Integer testNumber, boolean expected) {
        // TODO: refactor
        Lotto testLotto = new Lotto(List.of(5, 10, 15, 20, 25, 30));

        boolean actual = testLotto.numbersContain(testNumber);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> provideTestNumber() {
        return Stream.of(
                Arguments.of(1, false),
                Arguments.of(2, false),
                Arguments.of(5, true),
                Arguments.of(10, true),
                Arguments.of(34, false)
        );
    }

    @DisplayName("로또 구입 금액을 알려준다.")
    @Test
    void checkLottoPrice() {
        long expected = 1000;
        long actual = Lotto.getPrice();
        assertEquals(expected, actual);
    }
}