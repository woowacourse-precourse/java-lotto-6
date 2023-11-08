package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;


class LottoGeneratorTest {
    @DisplayName("로또 번호 생성 테스트.")
    @Test
    void testNegativeBuyingPrice() {
        List<Integer> numbers = LottoGenerator.getLottoNumbers();

        for (int number : numbers) {
            System.out.print(number + " ");
            assertTrue(number >= 1 && number <= 45);
        }
        for (int i = 0; i < numbers.size() - 1; ++i) {
            int currentNumber = numbers.get(i);
            int nextNumber = numbers.get(i + 1);
            assertTrue(currentNumber <= nextNumber);
        }
    }
}