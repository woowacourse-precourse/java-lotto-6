package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.prize.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("보너스 번호가 1 이상 45 이하의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createByNotLottoNumber() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int bonusNumber = 46;
            new WinningLotto(lotto, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 생성 정상")
    @Test
    void create() {
        assertDoesNotThrow(() -> {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int bonusNumber = 45;
            new WinningLotto(lotto, bonusNumber);
        });
    }

    @DisplayName("등수 계산")
    @Test
    void match() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        //when
        Lotto other = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Prize prize = winningLotto.match(other);

        //then
        assertThat(prize).isEqualTo(Prize.SECOND);
    }
}