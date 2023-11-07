package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoNumberGeneratorTest {

    @DisplayName("생성 단위 번호의 범위는 1부터 45까지다.")
    @Test
    void testGeneratedNumbersRange() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        for (int number : generator.generateNumbers()) {
            assertTrue(number >= 1 && number <= 45);
        }
    }

    @DisplayName("생성되는 단위 로또 번호 요소는 총 6개다.")
    @Test
    void testGeneratedNumbersSize() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        assertEquals(6, generator.generateNumbers().size());
    }

    @DisplayName("생성되는 단위 로또 번호 요소는 중복되지 않는다.")
    @Test
    void testGeneratedNumbersUniqueness() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        Set<Integer> uniqueNumbers = new HashSet<>(generator.generateNumbers());
        assertEquals(6, uniqueNumbers.size());
    }

    @DisplayName("생성되는 단위 로또 번호 요소는 오름차순으로 나열된다.")
    @Test
    void testGeneratedNumbersSorting() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        List<Integer> generatedNumbers = generator.generateNumbers();

        for (int i = 1; i < generatedNumbers.size(); i++) {
            assertTrue(generatedNumbers.get(i - 1) <= generatedNumbers.get(i));
        }
    }
}
