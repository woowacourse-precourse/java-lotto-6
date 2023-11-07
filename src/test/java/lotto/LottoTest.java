package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @Test
    void testValidLotto() {
        assertDoesNotThrow(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void testInvalidLottoSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals("6개의 숫자를 입력해주세요", exception.getMessage());
    }

    @Test
    void testInvalidLottoNumberRange() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(Arrays.asList(0, 2, 3, 4, 5, 6)));
        assertEquals("로또번호는 1과 45사이에 숫자여야함", exception.getMessage());
    }

    @Test
    void testDuplicateNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Lotto(Arrays.asList(1, 1, 3, 4, 5, 6)));
        assertEquals("중복된 로또번호가 있습니다.", exception.getMessage());
    }
    // 아래에 추가 테스트 작성 가능
}