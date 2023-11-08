package lotto.domain;

import lotto.constant.WinType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinCounterTest {
    private WinCounter winCounter;
    private List<WinType> winTypes;
    private List<Integer> winCounts;

    @BeforeEach
    void settings() {
        winCounter = new WinCounter();
        winTypes = List.of(WinType.values());
        winCounts = new ArrayList<>();
        for (int i = 0; i < winTypes.size(); i++) {
            winCounts.add(i);
            winCounter.put(winTypes.get(i), i);
        }
    }

    @DisplayName("[기능]WinCounter_출력하기__당첨 현황을 출력한다")
    @Test
    void winCounterToString() {
        assertThat(winCounter.toString())
                .isEqualTo("""
                        3개 일치 (5,000원) - 0개
                        4개 일치 (50,000원) - 1개
                        5개 일치 (1,500,000원) - 2개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - 3개
                        6개 일치 (2,000,000,000원) - 4개""");
    }

    @DisplayName("[기능]WinCounter_당첨세기__당첨 개수를 당첨케이스별로 셀 수 있다")
    @Test
    void put() {
        for (int i = 0; i < winTypes.size(); i++) {
            assertThat(winCounter.getCount(winTypes.get(i)))
                    .isEqualTo(winCounts.get(i));
        }
    }

    @DisplayName("[기능]WinCounter_수익률계산__넣은 돈에 비한 수익률을 계산할 수 있다")
    @Test
    void getRateOfReturn() {
        BigDecimal paidMoney = new BigDecimal(10000);
        assertThat(winCounter.getRateOfReturn(paidMoney))
                .isEqualTo("80930500%");
    }
}