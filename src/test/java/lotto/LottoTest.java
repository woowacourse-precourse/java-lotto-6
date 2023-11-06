package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("해당 번호가 로또에 있는지 확인")
    @Test
    void numberInLotto() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        // Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int checkNumber = 5;

        // When & Then
        assertTrue(lotto.numberInLotto(checkNumber));
    }

    @DisplayName("로또를 비교하여 같은 갯수 세기")
    @Test
    void calculateCorrectCount() {
        // Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));

        int expected = 3;

        // Then
        assertEquals(expected, lotto.calculateCorrectCount(winningLotto));
    }
}