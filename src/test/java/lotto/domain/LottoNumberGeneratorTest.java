package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberGeneratorTest {

    @Test
    @DisplayName("랜덤 생성된 로또 크기의 규격 테스트")
    void testGenerateLottoSize() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        Lotto lotto = generator.generateLotto();

        assertEquals(Lotto.MAX_NUMBERS, lotto.getNumbers().size());
    }

    @Test
    @DisplayName("랜덤 생성된 로또 번호의 범위 테스트")
    void testGenerateLottoRange() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        Lotto lotto = generator.generateLotto();

        for (int number : lotto.getNumbers()) {
            assertTrue(Lotto.MIN_VALUE <= number && number <= Lotto.MAX_VALUE);
        }
    }

    @Test
    @DisplayName("랜덤 생성된 로또 번호의 정렬 테스트")
    void testGenerateLottoSort() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        Lotto lotto = generator.generateLotto();

        List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
        Collections.sort(sortedNumbers);
        assertEquals(sortedNumbers, lotto.getNumbers());
    }

    @Test
    @DisplayName("생성된 로또 번호가 유효한지 확인하는 테스트")
    void testGenerateLotto() {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        Lotto lotto = generator.generateLotto();
        try {
            lotto.validate(lotto.getNumbers());
        } catch (Exception e) {
            fail("에러가 발생하면 안됩니다");
        }

    }
}