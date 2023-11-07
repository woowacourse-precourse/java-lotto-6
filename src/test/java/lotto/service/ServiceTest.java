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

    @DisplayName("로또 리스트가 잘 생성되는지 테스트")
    @Test
    void 로또_리스트_생성_테스트() {
        int lottoCount = 10;

        List<Lotto> lottoList = gameService.createLotto(lottoCount);
        assertEquals(lottoCount, lottoList.size());
    }

    @DisplayName("당첨 번호 리스트가 잘 생성되는지 테스트")
    @Test
    void 당첨_리스트_생성_테스트() {
        String numbers = "1, 2, 3, 4, 5, 6";
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> winNumberList = gameService.generateWinNumber(numbers);
        assertEquals(winNumberList, expectedList);
    }

    @DisplayName("보너스 번호 형 변환 테스트")
    @Test
    void 보너스_번호_생성_테스트() {
        String bonus = "5";
        int expectedBonusNumber = 5;

        int bonusNumber = gameService.generateBonusNumber(bonus);
        assertEquals(bonusNumber, expectedBonusNumber);
    }
}
