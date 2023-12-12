package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoBundleTest {

    @DisplayName("[Success]LottoBundle 객체 생성에 성공합니다.")
    @Test
    void createLottoBundle(){
        LottoBundle lottoBundle = new LottoBundle();
        int lottoTicketNumber = 10;
        assertDoesNotThrow(() -> lottoBundle.makeLottoBundle(lottoTicketNumber));
    }
}
