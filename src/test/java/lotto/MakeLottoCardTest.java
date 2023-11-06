package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class MakeLottoCardTest {

    @Test
    void pickNumbers() {
        MakeLottoCard lottoCard = new MakeLottoCard(1);
        List<Integer> numbers = lottoCard.pickNumbers();
        Lotto.validateRepeat(numbers);
    }

    @Test
    void 복수의로또카드만들기() {
        MakeLottoCard lottoCard = new MakeLottoCard(10);
        System.out.printf(String.valueOf(lottoCard.numbers.size()));
        assertEquals(10, lottoCard.numbers.size());
    }
}