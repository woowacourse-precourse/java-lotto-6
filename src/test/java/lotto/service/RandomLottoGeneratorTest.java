package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoGeneratorTest {

    private int purchaseAmount;

    @BeforeEach
    void init() {
        purchaseAmount = 3000;
    }

    @DisplayName("난수가 정상적으로 갯수에 맞게 잘 저장된다")
    @Test
    void createRandomLottoGeneratorAndCorrectCount() {
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator(purchaseAmount);
        Lottos lottos = randomLottoGenerator.generate();

        assertEquals(3, lottos.getLength());
    }
}