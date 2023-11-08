package lotto.domain.win;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.MockNumberGenerator;
import lotto.domain.Lotto;
import lotto.domain.user.LottoCount;
import lotto.domain.user.UserLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinLottoTest {
    @Test
    @DisplayName("동일한 로또 번호 개수를 잘 찾아내는지 확인한다.")
    void checkIsEqualAndBonus() {
        LottoCount lottoCount = LottoCount.from(1000);
        UserLotto userLotto = new UserLotto(lottoCount);
        userLotto.create(new MockNumberGenerator(List.of(1, 3, 5, 7, 9, 11)));

        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(7);
        WinLotto winLotto = new WinLotto(lotto, bonus);

        assertThat(winLotto.countEqual(userLotto.indexOf(0))).isEqualTo(3);
        assertThat(winLotto.countBonus(userLotto.indexOf(0))).isEqualTo(1);
    }
}
