package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void 값이_모두_유효할_경우_객체생성() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.of("9", winningNumbers);

        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        assertThat(winningLotto).isNotNull();
    }
}