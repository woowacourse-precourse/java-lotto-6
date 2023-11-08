package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
    @DisplayName("로또 당첨 번호와 보너스 번호 중복 시 예외가 발생한다.")
    @Test
    void duplicatedWinningLottoAndBonusNumber() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("3");
        assertThatThrownBy(() -> LottoResult.create(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
