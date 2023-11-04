package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TotalWinningTest {
    private TotalWinning totalWinning;
    private static final int first = 2_000_000_000;
    private static final int second = 30_000_000;
    private static final int third = 1_500_000;
    private static final int fourth = 50_000;
    private static final int fifth = 5_000;

    @BeforeEach
    @Test
    void createTotalWinning() {
        totalWinning = new TotalWinning(List.of(fifth));
    }

    @Test
    void getTotalReturn() {
        assertThat(totalWinning.getTotalReturn(new LottoPurchase(8000))).isEqualTo(62.5);
    }
}