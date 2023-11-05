package lotto.common;

import org.junit.jupiter.api.Test;

import static lotto.common.MessageType.*;
import static org.assertj.core.api.Assertions.assertThat;

class MessageTypeTest {

    @Test
    void testGetEaMessage() {
        int lottoCount = 8;
        String expectedMessage = "8개를 구매했습니다.";

        String actualMessage = PURCHASED_LOTTO_FORMAT.getEaMessage(lottoCount);

        assertThat(expectedMessage).isEqualTo(actualMessage);
    }

    @Test
    void testGetStatisticsMessage() {
        int matchCount = 3;
        int money = 5000;
        int ea = 1;
        boolean isLottoThirdRank = false;

        String expectedMessage = "3개 일치 (5,000원) - 1개";
        String actualMessage = WINNING_STATISTICS_FORMAT.getStatisticsMessage(matchCount, money, ea, isLottoThirdRank);

        assertThat(expectedMessage).isEqualTo(actualMessage);
    }
}