package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import lotto.enums.Rank;
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

    @DisplayName("당첨 여부 확인 리스트 생성 테스트")
    @Test
    void 당첨_여부_확인_리스트_생성_테스트() {
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13));
        List<Lotto> lottoList = Arrays.asList(lotto1, lotto2, lotto3);

        List<Rank> rankList = gameService.checkWinNumbers(winNumbers, lottoList, bonusNumber);

        assertEquals(3, rankList.size());
        assertEquals(Rank.FIRST, rankList.get(0));
        assertEquals(Rank.SECOND, rankList.get(1));
        assertEquals(Rank.FAIL, rankList.get(2));
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void 수익률_계산_테스트() {
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        int lottoCount = 10;

        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13));
        List<Lotto> lottoList = Arrays.asList(lotto1, lotto2, lotto3);

        List<Rank> rankList = gameService.checkWinNumbers(winNumbers, lottoList, bonusNumber);

        String realReturn = gameService.calculateReturnRate(rankList, lottoCount);
        int totalPrize = Rank.FIRST.getPrize() + Rank.SECOND.getPrize();
        double expectedReturnRate = ((double) totalPrize / (lottoCount * 1000)) * 100;
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        String expectedReturn = decimalFormat.format(expectedReturnRate) + "%입니다.";

        assertEquals(expectedReturn, realReturn);
    }
}
