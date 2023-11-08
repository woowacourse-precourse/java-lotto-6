package lotto.console.game.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @DisplayName("로또 발행 수량 - 성공 테스트")
    @Test
    public void issue_lotto_tickets_success_test() {
        // given
        Player player = new Player(8000);

        // when
        player.issueLottoTickets();

        // then
        assertEquals(8, player.getIssuedLottos().size());
    }

    @DisplayName("로또 발행 수량 - 실패 테스트")
    @Test
    public void issue_lotto_tickets_failure_test() {
        // given
        Player player = new Player(5000);

        // when
        player.issueLottoTickets();

        // then
        assertNotEquals(8, player.getIssuedLottos().size());
    }

    @DisplayName("수익률 계산 - 성공 테스트")
    @Test
    public void export_profit_rate_success_test() {
        // given
        Player player = new Player(5000);
        PrizeDetail prizeDetail = new PrizeDetail();
        prizeDetail.addFourthPrizeCount(); // 50000
        prizeDetail.addFifthPrizeCount(); // 5000
        player.receivePrizeDetail(prizeDetail);

        // when & then
        assertEquals("1100.0%", player.exportProfitRate());
    }

    @DisplayName("수익률 계산 - 실패 테스트")
    @Test
    public void export_profit_rate_failure_test() {
        // given
        Player player = new Player(5000);
        PrizeDetail prizeDetail = new PrizeDetail();
        prizeDetail.addSecondPrizeCount(); // 30000000
        prizeDetail.addFifthPrizeCount(); // 5000
        player.receivePrizeDetail(prizeDetail);

        // when & then
        assertNotEquals("1100.0%", player.exportProfitRate());
    }

}