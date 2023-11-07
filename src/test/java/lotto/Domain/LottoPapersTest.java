package lotto.Domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPapersTest {

    @Test
    @DisplayName("로또 티켓 수가 올바르게 생성되는지 확인")
    void shouldGenerateCorrectNumberOfLottoPapers() {
        int amount = 5;
        LottoPapers lottoPapers = new LottoPapers(amount);
        assertEquals(amount, lottoPapers.getLottoPapers().size());
    }


}