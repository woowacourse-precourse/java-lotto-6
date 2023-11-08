package lotto;

import lotto.model.Lotto;
import lotto.model.LottoDecision;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoDecisionTest {
    @DisplayName("당첨번호가 7글자 이상일 경우 예외가 발생한다")
    @Test
    void createWinningNumberOverSeven() {
        assertThatThrownBy(() -> new LottoDecision(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 7글자 이하일 경우 예외가 발생한다")
    @Test
    void createWinningNumberUnderSeven() {
        assertThatThrownBy(() -> new LottoDecision(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
