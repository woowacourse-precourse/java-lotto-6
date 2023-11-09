package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    @DisplayName("중복된 Bonus 값이 들어왔을 때 예외처리")
    void validateIsDuplicate() {
        List<Integer> a = List.of(1,2,3,4,5,6);
        Lotto init = new Lotto(a);
        WinningLotto winningLotto = new WinningLotto(init);

        assertThatThrownBy(
            () ->winningLotto.validateIsDuplicate(1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}