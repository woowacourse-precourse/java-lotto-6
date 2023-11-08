package lotto.console.game.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

    @DisplayName("로또 메시지 생성 - 성공 테스트")
    @Test
    void make_message_success_test() {
        // given
        Lotto lotto = new Lotto(List.of(2,4,5,6,1,3));

        // when & then
        assertEquals("[1, 2, 3, 4, 5, 6]", lotto.exportMessage());

    }

    @DisplayName("로또 메시지 생성 - 실패 테스트 (오름차순 정렬 발생)")
    @Test
    void make_message_failure_test_because_occur_accending_sort() {
        // given
        Lotto lotto = new Lotto(List.of(2,4,5,6,1,3));

        // when & then
        assertNotEquals("[2, 4, 5, 6, 1, 3]", lotto.exportMessage());
    }
}