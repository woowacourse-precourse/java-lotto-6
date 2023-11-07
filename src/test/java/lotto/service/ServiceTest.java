package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ServiceTest {

    private final GameService gameService = new GameService();

    @DisplayName("구입 금액 1000원 단위로 입력되는지 검증 테스트")
    @Test
    void 금액_테스트() {
        List<String> moneyList = Arrays.asList("10000", "500", "15000");
        List<Integer> expectedLottoCountList = Arrays.asList(10, 0, 15);
        for (int i = 0; i < moneyList.size(); i++) {
            String money = moneyList.get(i);
            int actualLottoCount = gameService.calculateLottoCount(money);
            int expectedLottoCount = expectedLottoCountList.get(i);

            assertEquals(expectedLottoCount, actualLottoCount);
        }
    }

    @DisplayName("Lotto list가 잘 생성되는지 테스트")
    @Test
    void 로또_리스트_생성_테스트() {
        int lottoCount = 10;

        List<Lotto> lottoList = gameService.createLotto(lottoCount);
        assertEquals(lottoCount, lottoList.size());
    }
}
