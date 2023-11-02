package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoProcessTest {
    private static final int LOTTO_PRICE = 1000;
    LottoProcess lottoProcess = new LottoProcess();

    @DisplayName("랜덤 번호 생성 확인")
    @Test
    void 랜덤_번호_생성_확인() {
        Assertions.assertNotNull(lottoProcess);
    }
}