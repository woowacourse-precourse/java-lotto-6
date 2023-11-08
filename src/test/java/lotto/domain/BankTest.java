package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BankTest {
    @DisplayName("당첨 번호와 로또 번호 일치하는 개수 테스트")
    @Test
    public void testCountCorrect() {
        Bank bank = new Bank();
        bank.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int correctCount = bank.countCorrect(lotto);
        assertEquals(6, correctCount);
    }
}