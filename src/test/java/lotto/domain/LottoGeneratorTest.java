package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    LottoGenerator generator = new LottoGenerator();

    @DisplayName("로또는 금액에 의해 정해진 발행 매수만큼 생성한다.")
    @Test
    void generateThreeLottos() {
        List<Lotto> lottos = generator.generateLotto(3);
        assertEquals(3, lottos.size());
    }

    @DisplayName("각 로또는 6개의 번호를 갖는다.")
    @Test
    void generateSixNumbersByEachLotto() {
        List<Lotto> lottos = generator.generateLotto(3);
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertEquals(6, numbers.size());
        }
    }

    @DisplayName("각 로또 번호는 1~45의 숫자 범위를 갖는다.")
    @Test
    void generateNumbersInRangeByEachLotto() {
        List<Lotto> lottos = generator.generateLotto(3);
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertTrue(numbers.stream().allMatch(number -> number >= 1 && number <= 45));
        }
    }

    @DisplayName("각 로또 번호는 서로 중복되지 않는다.")
    @Test
    void generateNonDuplicateNumberByEachLotto() {
        List<Lotto> lottos = generator.generateLotto(3);
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertEquals(6, numbers.stream().distinct().count());
        }
    }
}