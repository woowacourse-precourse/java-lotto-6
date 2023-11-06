package lotto.domain.win;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.MockNumberGenerator;
import lotto.domain.Lotto;
import lotto.domain.user.LottoCount;
import lotto.domain.user.UserLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinLottoTest {
    @Test
    @DisplayName("동일한 로또 번호 개수를 잘 찾아내는지 확인")
    void checkIsEqualAndBonus() {
        LottoCount lottoCount = new LottoCount(1000);
        UserLotto userLotto = new UserLotto(lottoCount);
        userLotto.create(new MockNumberGenerator());

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);
        WinLotto winLotto = new WinLotto(lotto, bonus);

        assertThat(winLotto.isEqual(userLotto.getLottos().get(0))).isEqualTo(3);
        assertThat(winLotto.isBonus(userLotto.getLottos().get(0))).isEqualTo(1);
    }
}
