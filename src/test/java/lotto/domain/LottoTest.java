package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Nested
    @DisplayName("로또 번호 예외 테스트")
    class LottoValidateTest {
        @Test
        void 로또_크기가_유효해야_한다() {
            List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
            assertThrows(IllegalArgumentException.class,()->new Lotto(numbers));
        }
        @Test
        void 로또_범위가_0보다_커야한다() {
            List<Integer> numbers = Arrays.asList(0,2,3,4,5,6);
            assertThrows(IllegalArgumentException.class,()->new Lotto(numbers));
        }

        @Test
        void 로또_범위가_45보다_같거나_작아야한다() {
            List<Integer> numbers = Arrays.asList(1,2,3,4,5,46);
            assertThrows(IllegalArgumentException.class,()->new Lotto(numbers));
        }
    }

    @Test
    @DisplayName("로또 번호 통과 테스트")
    void validLottoTest() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        assertDoesNotThrow(()-> new Lotto(numbers));
    }
}