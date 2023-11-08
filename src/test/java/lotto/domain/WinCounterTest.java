package lotto.domain;

import lotto.constant.WinType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    @DisplayName("[기능]WinCounter_당첨세기__당첨 개수를 당첨케이스별로 셀 수 있다")
    @Test
    void put() {
        for (int i = 0; i < winTypes.size(); i++) {
            Assertions.assertThat(winCounter.getCount(winTypes.get(i)))
                    .isEqualTo(winCounts.get(i));
        }
    }

    @DisplayName("[기능]WinCounter_수익률계산__넣은 돈에 비한 수익률을 계산할 수 있다")
    @Test
    void getRateOfReturn() {
        BigDecimal paidMoney = new BigDecimal(10000);
        System.out.println(winCounter.getRateOfReturn(paidMoney));
    }
}