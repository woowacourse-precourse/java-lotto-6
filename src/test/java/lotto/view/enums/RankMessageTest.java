package lotto.view.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankMessageTest {
    
    @DisplayName("순위에 맞는 순위 문자열을 반환한다.")
    @Test
    void getRankMessageByRank() {
        assertThat(RankMessage.getMessageByRank(1))
                .isEqualTo("6개 일치 (2,000,000,000원) - ");

        assertThat(RankMessage.getMessageByRank(2))
                .isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원) - ");

        assertThat(RankMessage.getMessageByRank(3))
                .isEqualTo("5개 일치 (1,500,000원) - ");

        assertThat(RankMessage.getMessageByRank(4))
                .isEqualTo("4개 일치 (50,000원) - ");

        assertThat(RankMessage.getMessageByRank(5))
                .isEqualTo("3개 일치 (5,000원) - ");
    }

}