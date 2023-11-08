package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.ErrorMessage.BONUS_DUPLICATED;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @Test
    @DisplayName("범위 밖의 숫자로 로또 번호를 생성할 경우 예외 발생")
    void createNumberInWinningTicket() {
        Lotto winningTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(new LottoNumber(6), winningTicket))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_DUPLICATED);
    }

    @Test
    @DisplayName("중복이 아닐 때 정상적으로 생성되는지")
    void create() {
        Lotto winningTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatCode(() -> new BonusNumber(new LottoNumber(7), winningTicket)).doesNotThrowAnyException();
    }
}
