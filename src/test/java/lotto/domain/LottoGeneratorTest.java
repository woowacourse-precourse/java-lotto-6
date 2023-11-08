package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    @DisplayName("lotto Generator가 정상 작동하는 지 확인하기")
    @Test
    void checkLottoGenerator() {
        int gameAmount = 4;
        LottoGenerator lottoGenerator = new LottoGenerator();
        System.out.println(lottoGenerator.lottoGenerateWinningLotto(gameAmount));
    }

}