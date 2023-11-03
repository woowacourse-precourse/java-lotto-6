package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TotalWinningTest {
    @Test
    void createTotalWinning() {
        int first = 2_000_000_000;
        int third = 1_500_000;
        TotalWinning totalWinning = new TotalWinning(List.of(first, third));
    }
}