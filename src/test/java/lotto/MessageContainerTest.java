package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.PrizeCategory;
import org.junit.jupiter.api.Test;

class MessageContainerTest {
    @Test
    void createWinningDetails_메서드로_당첨_내역_안내_메시지_생성() {
        Map<PrizeCategory, Integer> map = new HashMap<>();
        map.put(PrizeCategory.SIXTH, 1);
        map.put(PrizeCategory.FIFTH, 2);
        map.put(PrizeCategory.FOURTH, 0);
        map.put(PrizeCategory.THIRD, 1);
        map.put(PrizeCategory.SECOND, 1);
        map.put(PrizeCategory.FIRST, 0);
        MessageContainer messageContainer = new MessageContainer();

        List<String> actual = messageContainer.createWinningDetails(map);

        assertThat(actual).containsExactly("3개 일치 (5,000원) - 2개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 0개");
    }
}