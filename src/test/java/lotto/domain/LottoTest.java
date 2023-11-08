package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

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

    @Nested
    @DisplayName("로또 번호 비교 테스트")
    class lottoCompareTest {
        @Test
        void 두_로또번호의_중복되는_수의_개수를_반환한다() {
            Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
            Lotto lotto2 = new Lotto(Arrays.asList(1,2,3,4,5,7));
            assertEquals(5,lotto1.countMatchingNumbers(lotto2));
        }
        @Test
        void 로또에_보너스_번호가_포함되어있으면_true를_반환한다() {
            Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
            BonusNumber bonusNumber = new BonusNumber(3,new Lotto(Arrays.asList(1,2,4,5,6,7)));
            assertEquals(true,lotto.containsNumber(bonusNumber.getNumber()));
            assertEquals(false, lotto.containsNumber(9));
        }
    }
}