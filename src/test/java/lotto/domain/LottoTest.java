package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또의 반환된 리스트가 수정이 불가능인지 확인한다.")
    @Test
    void returnLottoListAsUnmodifiable() {
        List<Integer> numbers = List.of(7, 8, 9, 10, 11, 12);
        Lotto lotto = new Lotto(numbers);
        List<Integer> retrievedNumbers = lotto.getNumbers();
        assertThrows(UnsupportedOperationException.class, () -> retrievedNumbers.add(13));
    }

    @DisplayName("로또안에 숫자가 포함되어 있는지 확인한다")
    @Test
    void testContains() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertTrue(lotto.contains(1));
        assertTrue(lotto.contains(2));
        assertFalse(lotto.contains(7));
        assertFalse(lotto.contains(8));
    }

    @DisplayName("로또가 String형태로 잘 나오는지 확인한다.")
    @Test
    void testToString() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        String lottoString = "[1, 2, 3, 4, 5, 6]";
        String getLottoString = lotto.toString();

        assertThat((getLottoString)).isEqualTo(lottoString);
    }

}