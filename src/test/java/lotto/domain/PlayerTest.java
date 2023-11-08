package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {
    Player player;

    @BeforeEach
    void SetUp() {
        player = new Player();
    }

    @Test
    void 구입_금액_입력() {
        int purChaseAmountInput = 100000;
        player.insertPurchaseAmount(purChaseAmountInput);

        assertEquals(purChaseAmountInput, player.getPurChaseAmount());
    }
}
