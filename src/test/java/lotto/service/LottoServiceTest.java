package lotto.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.Map;
import lotto.constant.LottoResultRule;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.Ticket;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistic;
import lotto.utils.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoService의")
class LottoServiceTest {

    final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    final LottoService lottoService = new LottoService(randomNumberGenerator);

    @Test
    @DisplayName("티켓이 반환되는가")
    void return_ticket_from_amount() {
        //given
        final Ticket expectedTicket = new Ticket(1);
        final PurchaseAmount purchaseAmount = new PurchaseAmount(1000);

        //when
        final Ticket actualTicket = lottoService.calculateTicketFromAmonut(purchaseAmount);

        //then
        assertThat(actualTicket.toValue()).isEqualTo(expectedTicket.toValue());
    }

    @Test
    @DisplayName("로또가 저장이 되는가")
    void save_lottos_from_ticket() {
        //given
        final Ticket ticket = new Ticket(3);

        //when
        final Lottos actualLottos = lottoService.saveLottos(ticket);

        //then
        assertThat(actualLottos.toElements().size()).isEqualTo(ticket.toValue());
    }

    @Test
    @DisplayName("로또 값을 비교해서 반환하는가?")
    void compare_lotto() {
        //given
        final Lotto sixMatchLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        final Lotto fiveMatchLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        final Lotto fiveMatchWithBonusLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        final Lotto fourMatchLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10));
        final Lotto threeMatchLotto = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));

        final Lotto winningLottoNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        final Integer bonusNumber = 7;

        final Lottos lottos = new Lottos(
                Arrays.asList(sixMatchLotto, fiveMatchLotto, fiveMatchWithBonusLotto, fourMatchLotto, threeMatchLotto));
        final WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        winningLotto.updateBonusNumber(bonusNumber);

        //when
        final WinningStatistic winningStatistic = lottoService.compareLotto(lottos, winningLotto);

        //then
        assertThat(winningStatistic.toElements()).isEqualTo(Map.of(
                LottoResultRule.THREE_MATCH, 1,
                LottoResultRule.FOUR_MATCH, 1,
                LottoResultRule.FIVE_MATCH, 1,
                LottoResultRule.FIVE_MATCH_WITH_BONUS, 1,
                LottoResultRule.SIX_MATCH, 1,
                LottoResultRule.NONE, 0
        ));
    }

    @Test
    void get_performance() {
        //given
        final Lotto sixMatchLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        final Lotto fiveMatchLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        final Lotto fiveMatchWithBonusLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        final Lotto fourMatchLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10));
        final Lotto threeMatchLotto = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));

        final Lotto winningLottoNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        final Integer bonusNumber = 7;

        final Lottos lottos = new Lottos(
                Arrays.asList(sixMatchLotto, fiveMatchLotto, fiveMatchWithBonusLotto, fourMatchLotto, threeMatchLotto));
        final WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

        winningLotto.updateBonusNumber(bonusNumber);

        final PurchaseAmount purchaseAmount = new PurchaseAmount(5000);

        final WinningStatistic winningStatistic = lottoService.compareLotto(lottos, winningLotto);

        //when
        final String performance = lottoService.getPerformance(winningStatistic, purchaseAmount);

        //then
        assertThat(performance).isNotNull();
    }
}