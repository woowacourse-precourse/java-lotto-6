package lotto.domain.ticket;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningTicketTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 다르면 정상적으로 생성한다.")
    void 당첨_번호와_보너스_번호가_다르면_정상적으로_생성한다() {
        // given
        var winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        var bonusNumber = LottoNumber.of(7);

        // when
        var winningTicket = new WinningTicket(winningNumbers, bonusNumber);

        // then
        assertThat(winningTicket).isNotNull();
        assertThat(winningTicket.winningLotto()).isEqualTo(winningNumbers);
        assertThat(winningTicket.bonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 같으면 예외를 발생시킨다.")
    void 당첨_번호와_보너스_번호가_같으면_예외를_발생시킨다() {
        // given
        var winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        var bonusNumber = LottoNumber.of(6);

        // when & then
        assertThatThrownBy(() -> new WinningTicket(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또와 당첨 번호를 비교하여 로또 결과를 반환한다.")
    void 로또와_당첨_번호를_비교하여_로또_결과를_반환한다() {
        // given
        var winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        var bonusNumber = LottoNumber.of(7);
        var winningTicket = new WinningTicket(winningLotto, bonusNumber);
        var lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        var lottoResult = winningTicket.match(lotto);

        // then
        assertThat(lottoResult).isNotNull();
        assertThat(lottoResult.matchCount()).isEqualTo(6);
        assertThat(lottoResult.hasBonusNumber()).isFalse();
    }
}
