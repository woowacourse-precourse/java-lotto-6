package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    private static final Lotto LOTTO_TEST_INSTANCE = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private static final Integer CONTAINED_NUMBER = 3;
    private static final Integer NOT_CONTAINED_NUMBER = 45;

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

    @DisplayName("contains 메서드 작동 확인 테스트")
    @Test
    void containsTest() {
        assertTrue(LOTTO_TEST_INSTANCE.contains(CONTAINED_NUMBER));

        assertFalse(LOTTO_TEST_INSTANCE.contains(NOT_CONTAINED_NUMBER));
    }

    @DisplayName("countSameNumbers 메서드 작동 확인 테스트")
    @Test
    void countSameNumbers() {
        Lotto otherTestInstance = new Lotto(List.of(3, 4, 5, 6, 7, 8));

        Integer expected = 4;
        assertEquals(expected, LOTTO_TEST_INSTANCE.countSameNumbers(otherTestInstance));
    }
}