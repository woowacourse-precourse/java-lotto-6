package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {

    @Test
    @DisplayName("테스트 전 enum값들 생성")
    void setUp() {
        WinningResult.countLottoResult(3, false);
        WinningResult.countLottoResult(4, false);
        WinningResult.countLottoResult(5, true);
    }

}
