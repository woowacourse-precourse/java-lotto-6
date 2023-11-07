package lotto.view.message;

import static lotto.view.message.RankMessage.MESSAGE_FOURTH;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankMessageTest {
    @Test
    void 등수로_등수메세지_찾기() {
        assertThat(RankMessage.findByRank(4)).isEqualTo(MESSAGE_FOURTH);
    }

    @Test
    void 메세지_얻기() {
        assertThat(String.format(MESSAGE_FOURTH.getMessage(), 1)).isEqualTo("4개 일치 (50,000원) - 1개");
    }

    @Test
    void 등수_얻기() {
        assertThat(MESSAGE_FOURTH.getRank()).isEqualTo(4);
    }
}