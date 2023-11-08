package lotto.domain;

import static lotto.message.ViewMessage.PROFIT_FORMAT;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultSheetTest {
    private ResultSheet resultSheet;

    @BeforeEach
    void setUp() {
        Map<Rank, Integer> sheet = new HashMap<>();
        sheet.put(Rank.FIRST, 1);
        sheet.put(Rank.SECOND, 0);
        sheet.put(Rank.THIRD, 2);
        sheet.put(Rank.FOURTH, 10);
        sheet.put(Rank.FIFTH, 50);
        sheet.put(Rank.NO_RANK, 100);
        resultSheet = new ResultSheet(sheet);
    }

    @DisplayName("당첨 개수를 일치하게 반환한다.")
    @Test
    void findCountByRank() {
        int countByRank = resultSheet.findCountByRank(Rank.FIRST);

        Assertions.assertThat(countByRank).isEqualTo(1);
    }

    @DisplayName("총 당첨 개수를 일치하게 추가한다.")
    @Test
    void getTotalCount() {
        int totalCount = resultSheet.getTotalCount();

        Assertions.assertThat(totalCount).isEqualTo(163);
    }

    @DisplayName("수익률을 일치하게 반환한다.")
    @Test
    void getTotalProfit() {
        double totalProfit = resultSheet.getTotalProfit();

        String format = PROFIT_FORMAT.format(totalProfit);
        Assertions.assertThat(format).isEqualTo("1,229,294.5");
    }
}