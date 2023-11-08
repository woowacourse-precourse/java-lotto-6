package lotto;

import lotto.model.LottoManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoManagerTest {

    @DisplayName("보너스 번호 입력이 1~45 범위가 아니라면 예외가 발생한다.")
    @Test
    void validateBonusNumbersInRange() {
        LottoManager lottoManager = new LottoManager(List.of(1, 2, 3, 4, 5, 6));
        int outOfRangeBonusNumber = 46;
        assertThatThrownBy(() -> lottoManager.addBonusNumber(outOfRangeBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨번호와 중복된 숫자가 있다면 예외가 발생한다.")
    @Test
    void validateWinningNumbersAndBonusNumberDuplicate() {
        LottoManager lottoManager = new LottoManager(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lottoManager.addBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
