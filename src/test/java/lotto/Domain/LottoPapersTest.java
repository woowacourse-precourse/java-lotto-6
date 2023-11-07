package lotto.Domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    @Test
    @DisplayName("로또 번호가 유효한 범위 내에 있는지 확인")
    void shouldGenerateValidLottoNumbers() {
        int amount = 5;
        LottoPapers lottoPapers = new LottoPapers(amount);

        for (Lotto lotto : lottoPapers.getLottoPapers()) {
            for (int number : lotto.getNumbers()) {
                assertTrue(number >= 1 && number <= 45);
            }
        }
    }

    @Test
    @DisplayName("로또 번호가 올바른 갯수만큼 있는지 확인")
    void shouldGenerateUniqueAndCorrectNumberOfLottoNumbers() {
        int amount = 5;
        LottoPapers lottoPapers = new LottoPapers(amount);

        for (Lotto lotto : lottoPapers.getLottoPapers()) {
            assertEquals(6, lotto.getNumbers().size());
        }
    }
}