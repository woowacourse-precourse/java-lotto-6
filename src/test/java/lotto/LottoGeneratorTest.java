package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoGeneratorTest {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    @Test
    public void testGenerate() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = lottoGenerator.generate();
        List<Integer> numbers = lotto.getNumbers();

        // 로또 번호가 6개인지 확인
        assertEquals(LOTTO_SIZE, numbers.size(), "Generated lotto should have exactly " + LOTTO_SIZE + " numbers.");

        // 로또 번호가 모두 1과 45 사이인지 확인
        numbers.forEach(number ->
                assertTrue(number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX,
                        "Each lotto number should be between " + LOTTO_NUMBER_MIN + " and " + LOTTO_NUMBER_MAX + ".")
        );

        // 로또 번호에 중복이 없는지 확인
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        assertEquals(numbers.size(), uniqueNumbers.size(), "Lotto numbers should be unique.");
    }
}
