package lotto.config;

import static org.junit.jupiter.api.Assertions.*;

import lotto.service.LottoService;
import lotto.service.WinningService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoApplicationConfig 테스트")
class LottoApplicationConfigTest {

    @Test
    @DisplayName("LottoService 생성 테스트")
    void testCreateLottoService() {
        LottoApplicationConfig config = new LottoApplicationConfig();
        LottoService lottoService = config.createLottoService();
        assertNotNull(lottoService, "LottoService는 null이 아니어야 합니다");
    }

    @Test
    @DisplayName("WinningService 생성 테스트")
    void testCreateWinningService() {
        LottoApplicationConfig config = new LottoApplicationConfig();
        WinningService winningService = config.createWinningService();
        assertNotNull(winningService, "WinningService는 null이 아니어야 합니다");
    }
}