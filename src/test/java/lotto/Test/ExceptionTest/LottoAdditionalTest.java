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
    @DisplayName("번호는 1에서 45 사이여야 한다")
    void RangeTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertTrue(lotto.getNumbers().stream().allMatch(number -> number >= 1 && number <= 45));
    }

    @Test
    @DisplayName("번호에 중복이 없어야 한다")
    void DuplicateTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertEquals(numbers.size(), new HashSet<>(lotto.getNumbers()).size());
    }

    @Test
    @DisplayName("입력된 번호가 없으면 예외를 던진다")
    void EmptyTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(null));
        assertEquals("[ERROR] 입력된 번호가 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("입력된 번호가 6개가 아니면 예외를 던진다")
    void NumberOfInputsTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
        assertEquals("[ERROR] 번호는 6개여야 합니다. 현재 개수: " + numbers.size(), exception.getMessage());
    }

}


