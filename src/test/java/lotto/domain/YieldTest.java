package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class YieldTest {
    @DisplayName("수익금을 올바르게 가져온다.")
    @Test
    void getTotalWinningPrice() {
        List<Grade> grades = List.of(Grade.SECOND, Grade.THIRD);
        int totalInvestment = 8_000;
        Yield yield = new Yield(grades,totalInvestment);

        assertThat(yield.getTotalWinningPrice()).isEqualTo(31_500_000);
    }

}