package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoGeneratorTest {

    @Test
    @DisplayName("유효한 로또 번호를 생성한다")
    void generateLottoShouldGenerateValidLotto() {
        Lotto lotto = LottoGenerator.generateLotto();

        assertNotNull(lotto);
        assertEquals(6, lotto.getNumbers().size());

        Set<Integer> uniqueNumbers = lotto.getNumbers().stream().collect(Collectors.toSet());
        assertEquals(6, uniqueNumbers.size());

        for (int number : lotto.getNumbers()) {
            assertTrue(number >= 1 && number <= 45);
        }
    }

    @Test
    @DisplayName("지정된 개수의 로또를 생성한다")
    void generateLottosShouldGenerateValidNumberOfLottos() {
        int count = 5;
        List<Lotto> lottos = LottoGenerator.generateLottos(count);

        assertNotNull(lottos);
        assertEquals(count, lottos.size());
    }

    @Test
    @DisplayName("로또 개수가 0 이하일 때 예외가 발생한다")
    void generateLottosShouldThrowExceptionForInvalidCount() {
        assertThrows(IllegalArgumentException.class, () -> LottoGenerator.generateLottos(0));
        assertThrows(IllegalArgumentException.class, () -> LottoGenerator.generateLottos(-1));
    }
}
