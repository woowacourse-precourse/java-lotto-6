package lotto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

public class LottoNumbersTest {

    @Test
    public void testSetRandomNumbers() {
        List<Integer> randomNumbers = LottoNumbers.setRandomNumbers();
        
        // 랜덤 로또 번호가 6개인지 확인
        assertEquals(6, randomNumbers.size());
        
        // 로또 번호가 1부터 45 사이의 숫자인지 확인
        for (int number : randomNumbers) {
            assertTrue(number >= 1 && number <= 45);
        }
        
        // 중복되지 않는지 확인
        assertEquals(6, new HashSet<>(randomNumbers).size());
    }
}
