package lotto.serviceTest;


import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.Service.ReturnCalcService;
import lotto.model.Rank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RandomCalcServiceTest extends NsTest {
    ReturnCalcService returnCalcService = new ReturnCalcService();

    @DisplayName("등수 별 개수 정보를 담은 리스트를 입력받아 올바르게 총 상금을 계산한다.")
    @Test
    public void 총_상금_계산() {
        // given
        List<Integer> rankingResult = Arrays.asList(0, 0, 1, 0, 3, 1); // MATCH_3 1개, MATCH_4 3개, MATCH_5 0개, MATCH_5_BONUS 1개, MATCH_6 0개
        int expectedTotalPrize = Rank.MATCH_3.getprizeMoney() * 1
                + Rank.MATCH_4.getprizeMoney() * 3
                + Rank.MATCH_5.getprizeMoney() * 0
                + Rank.MATCH_5_BONUS.getprizeMoney() * 1
                + Rank.MATCH_6.getprizeMoney() * 0;

        // when
        int totalPrize = returnCalcService.calculateTotalPrize(rankingResult);

        // then
        Assertions.assertEquals(expectedTotalPrize, totalPrize);
    }

    @DisplayName("구매 가격과 총 상금을 입력받아 올바르게 수익률을 계산한다.")
    @Test
    public void 수익률_계산() {
        // given
        int purchasePrice = 8000;
        int totalPrize = 5000;
        String expectedReturnRate = "62.5";

        // when
        String returnRate = returnCalcService.calculateReturnRate(purchasePrice, totalPrize);

        // then
        Assertions.assertEquals(expectedReturnRate, returnRate);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
