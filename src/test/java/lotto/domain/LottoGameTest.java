package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    private final LottoTicketDispenser ticketDispenser = new LottoTicketDispenser(new AutoLottoNumberGenerator());

    @Test
    void 로또_게임에_금액을_입력하면_구매된_로또_목록을_얻을_수_있다() {
        // given
        AutoCreatedLottoGame autoCreatedLottoGame = new AutoCreatedLottoGame(ticketDispenser);
        String cost = "2000";
        // when
        PurchasedLottoTickets purchasedLottoTickets = autoCreatedLottoGame.purchaseLottoTickets(cost);
        // then
        assertThat(purchasedLottoTickets.size()).isEqualTo(2);
    }

    @Test
    void 로또_게임에_유효하지_않은_금액을_입력하면_예외가_발생한다() {
        // given
        AutoCreatedLottoGame autoCreatedLottoGame = new AutoCreatedLottoGame(ticketDispenser);
        String cost = "2000A";
        // when
        // then
        assertThatThrownBy(() -> autoCreatedLottoGame.purchaseLottoTickets(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 금액입니다.");
    }

    @Test
    void 로또_게임의_당첨_번호로_당첨_로또를_생성한다() {
        // given
        AutoCreatedLottoGame autoCreatedLottoGame = new AutoCreatedLottoGame(ticketDispenser);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto expectedLotto = new Lotto(numbers);
        // when
        Lotto actualLotto = autoCreatedLottoGame.createWinningLotto(numbers);
        // then
        assertThat(actualLotto.confirmLottoWinning(expectedLotto, 7))
                .isEqualTo(LottoWinning.FIRST);
    }
}