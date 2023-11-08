package lotto.message;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoGameAnnouncementTest {

    @Test
    public void getProfitMessageTest() {
        // given
        double profit = 62.5;

        // when
        String profitMessage = LottoGameAnnouncement.getProfitPercentageMessage(profit);

        // then
        assertEquals(profitMessage, "총 수익률은 62.5%입니다.");
    }
}