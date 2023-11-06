package lotto;

import lotto.domain.Lotto;
import lotto.domain.UserLottoNum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserLottoNumTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createUserLottoDuplicateByBonusNum() {
        assertThatThrownBy(() -> new UserLottoNum(new Lotto(List.of(1,2,3,4,5,6)),5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 범위에 없을 때 예외가 발생한다.")
    @Test
    void createUserLottoOutRangeBonusNum() {
        assertThatThrownBy(() -> new UserLottoNum(new Lotto(List.of(1,2,3,4,5,6)),65))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
