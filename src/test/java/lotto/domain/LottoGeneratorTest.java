package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    @DisplayName("check if lottoGenerator works")
    @Test
    void checkLottoGenerator() {
        int gameAmount = 4;
        LottoGenerator lottoGenerator = new LottoGenerator();
        System.out.println(lottoGenerator.lottoGenerateWinningLotto(gameAmount));
    }

}