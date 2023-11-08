package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RandomLottoMachineTest {

    @Test
    void 올바르게_로또_생성() {
        // Given
        LottoMachine lottoMachine = new RandomLottoMachine();
        int expectedResult = getRandomLottoCount();

        // When
        List<Lotto> lottos = lottoMachine.generateLottos(expectedResult);

        // Then
        assertEquals(expectedResult, lottos.size());
    }

    private int getRandomLottoCount() {
        return (int)(Math.random() * 10) + 1;
    }
}