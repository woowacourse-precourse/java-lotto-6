package lotto.Test.ExceptionTest;

import lotto.model.lottoResultChecker.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class LottoAdditionalTest {
    @Test
    @DisplayName("번호는 6개여야 한다")
    void shouldHaveSixNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertEquals(6, lotto.getNumbers().size());
    }

    @Test
    @DisplayName("번호는 1에서 45 사이여야 한다")
    void shouldOnlyContainNumbersBetweenOneAndFortyFive() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertTrue(lotto.getNumbers().stream().allMatch(number -> number >= 1 && number <= 45));
    }

    @Test
    @DisplayName("번호에 중복이 없어야 한다")
    void shouldNotContainDuplicateNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertEquals(numbers.size(), new HashSet<>(lotto.getNumbers()).size());
    }

    @Test
    @DisplayName("입력된 번호가 없으면 예외를 던진다")
    void shouldThrowExceptionWhenNoNumbersAreGiven() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(null));
        assertEquals("[ERROR] 입력된 번호가 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("입력된 번호가 6개가 아니면 예외를 던진다")
    void shouldThrowExceptionWhenNotSixNumbersAreGiven() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
        assertEquals("[ERROR] 번호는 6개여야 합니다. 현재 개수: " + numbers.size(), exception.getMessage());
    }

    @Test
    @DisplayName("번호가 1~45 사이가 아니면 예외를 던진다")
    void shouldThrowExceptionWhenNumbersAreNotWithinRange() {
        List<Integer> numbers = Arrays.asList(0, 2, 3, 4, 5, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
        assertEquals("[ERROR] 번호는 1에서 45 사이여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("번호에 중복이 있으면 예외를 던진다")
    void shouldThrowExceptionWhenDuplicateNumbersAreGiven() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 5, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
        assertEquals("[ERROR] 번호는 중복될 수 없습니다.", exception.getMessage());
    }
}


