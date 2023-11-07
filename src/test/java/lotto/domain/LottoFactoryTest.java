package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    @DisplayName("로또 번호가 1-45 사이의 숫자 이고 6자리인 로또 생성 검증하기")
    @Test
    public void testGenerateLotto(){
        Lotto lotto = LottoFactory.generateLotto();
        List<Integer> numbers = lotto.getNumbers();
        assertEquals(6, numbers.size());
        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 45);
        }
    }
}