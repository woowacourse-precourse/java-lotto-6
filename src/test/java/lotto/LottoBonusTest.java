package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBonusTest {
    @DisplayName("로또 당첨 번호와 중복된 보너스 번호를 입력하면 예외가 발생한다.")
    @Test
    void createLottoBonusByDuplicateLotto() {
        assertThatThrownBy(() -> new LottoBonus(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어난 보너스 번호를 입력하면 예외가 발생한다.(MAX)")
    @Test
    void createLottoBonusByOverMaxRange() {
        assertThatThrownBy(() -> new LottoBonus(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어난 보너스 번호를 입력하면 예외가 발생한다.(MIN)")
    @Test
    void createLottoBonusByOverMinRange() {
        assertThatThrownBy(() -> new LottoBonus(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
