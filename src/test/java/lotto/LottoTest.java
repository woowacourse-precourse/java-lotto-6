package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호에 1~45이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    public void testValidate_InvalidNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 46); // Invalid number
        assertThrows(IllegalArgumentException.class, () -> new Lotto(numbers));
    }
    @DisplayName("두 로또 번호 리스트가 일부 일치하면, 일치하는 숫자의 개수를 반환한다.")
    @Test
    public void testMatchCount() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        assertEquals(3, userLotto.matchCount(winningLotto));
    }
}