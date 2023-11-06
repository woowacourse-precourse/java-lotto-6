package lotto.vo;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningNumbersTest {
    Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("당첨 번호들에 같은 로또 값의 로또와 같은 보너스 번호를 가지면 같은 해시 코드를 가진다.")
    void 같은_해시_코드() {
        LottoWinningBonusNumber bonusNumber = new LottoWinningBonusNumber(7);
        LottoWinningNumbers lottoWinningNumbers1 = new LottoWinningNumbers(lotto, bonusNumber);
        LottoWinningNumbers lottoWinningNumbers2 = new LottoWinningNumbers(lotto, bonusNumber);

        assertThat(lottoWinningNumbers1).hasSameHashCodeAs(lottoWinningNumbers2);
    }

    @Test
    @DisplayName("로또 당첨 번호들(VO)은 값이 같으면 동등 하다")
    void 로또_번호_동등성_비교() {
        LottoWinningNumbers lottoWinningNumbers1 = new LottoWinningNumbers(lotto, new LottoWinningBonusNumber(7));
        LottoWinningNumbers lottoWinningNumbers2 = new LottoWinningNumbers(lotto, new LottoWinningBonusNumber(8));
        LottoWinningNumbers lottoWinningNumbers3 = new LottoWinningNumbers(lotto, new LottoWinningBonusNumber(7));

        assertThat(lottoWinningNumbers1).isNotEqualTo(lottoWinningNumbers2);
        assertThat(lottoWinningNumbers1).isEqualTo(lottoWinningNumbers3);
    }

    @Test
    @DisplayName("로또 당첨 번호들(VO))은 값이 같으면 동등 하고, 같은 해시 코드를 가진다.")
    void 로또_번호_해시_코드_비교() {
        LottoWinningNumbers lottoWinningNumbers1 = new LottoWinningNumbers(lotto, new LottoWinningBonusNumber(7));
        LottoWinningNumbers lottoWinningNumbers2 = new LottoWinningNumbers(lotto, new LottoWinningBonusNumber(8));
        LottoWinningNumbers lottoWinningNumbers3 = new LottoWinningNumbers(lotto, new LottoWinningBonusNumber(7));

        assertThat(lottoWinningNumbers1).doesNotHaveSameHashCodeAs(lottoWinningNumbers2);
        assertThat(lottoWinningNumbers1).hasSameHashCodeAs(lottoWinningNumbers3);
    }

    @Test
    @DisplayName("로또 당첨 번호들(VO)은 값이 같으면 동등 하고, 같은 해시 코드를 가져도, 동일 하지 않다.")
    void 로또_번호_동일성_비교() {
        LottoWinningNumbers lottoWinningNumbers1 = new LottoWinningNumbers(lotto, new LottoWinningBonusNumber(7));
        LottoWinningNumbers lottoWinningNumbers2 = new LottoWinningNumbers(lotto, new LottoWinningBonusNumber(8));
        LottoWinningNumbers lottoWinningNumbers3 = new LottoWinningNumbers(lotto, new LottoWinningBonusNumber(7));

        assertThat(lottoWinningNumbers1).isNotSameAs(lottoWinningNumbers2);
        assertThat(lottoWinningNumbers1).isNotSameAs(lottoWinningNumbers3);
    }
}