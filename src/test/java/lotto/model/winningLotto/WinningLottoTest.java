package lotto.model.winningLotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("WinningLotto가 잘 생성된다.")
    @Test
    void createWinningLotto(){
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinningLotto winningLotto = WinningLotto.of(winningNumber, bonusNumber);

        assertThat(winningLotto).isNotNull();
    }

    @DisplayName("WinningLotto를 WinningLottoDTO로 변환한다.")
    @Test
    void convertToWinningLottoDTO(){
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinningLotto winningLotto = WinningLotto.of(winningNumber, bonusNumber);
        WinningLottoDTO winningLottoDTO = winningLotto.toWinningLottoDTO();

        assertThat(winningLottoDTO.winningNumber()).isEqualTo(winningNumber);
        assertThat(winningLottoDTO.bonusNumber()).isEqualTo(bonusNumber);

    }

}