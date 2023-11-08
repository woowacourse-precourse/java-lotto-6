package lotto;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameServiceTest {

    @DisplayName("등수별 상금 출력 테스트")
    @Test
    void makeResultTest() {
        LottoGameService lottoGameService = new LottoGameService();

        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Integer> firstPrizeNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> secondPrizeNumbers = Arrays.asList(1, 2, 3, 4, 5, 16);
        List<Integer> thirdPrizeNumbers = Arrays.asList(1, 2, 3, 4, 5, 16);
        List<Integer> fourthPrizeNumbers = Arrays.asList(1, 2, 3, 4, 15, 16);
        List<Integer> fifthPrizeNumbers = Arrays.asList(1, 2, 3, 14, 15, 16);

        List<Integer> noPrizeNumbers1 = Arrays.asList(1, 2, 13, 14, 15, 16); // matchCount 2
        List<Integer> noPrizeNumbers2 = Arrays.asList(1, 12, 13, 14, 15, 16); // matchCount 1
        List<Integer> noPrizeNumbers3 = Arrays.asList(11, 12, 13, 14, 15, 16); // matchCOunt 0

        Assertions.assertEquals(
            lottoGameService.makeResult(lotto, firstPrizeNumbers, 7).getTotalMoney(), 2000000000);
        Assertions.assertEquals(
            lottoGameService.makeResult(lotto, secondPrizeNumbers, 16).getTotalMoney(), 30000000);
        Assertions.assertEquals(
            lottoGameService.makeResult(lotto, thirdPrizeNumbers, 14).getTotalMoney(), 1500000);
        Assertions.assertEquals(
            lottoGameService.makeResult(lotto, fourthPrizeNumbers, 16).getTotalMoney(), 50000);
        Assertions.assertEquals(
            lottoGameService.makeResult(lotto, fifthPrizeNumbers, 16).getTotalMoney(), 5000);

        Assertions.assertEquals(
            lottoGameService.makeResult(lotto, noPrizeNumbers1, 16).getTotalMoney(), 0);
        Assertions.assertEquals(
            lottoGameService.makeResult(lotto, noPrizeNumbers2, 16).getTotalMoney(), 0);
        Assertions.assertEquals(
            lottoGameService.makeResult(lotto, noPrizeNumbers3, 16).getTotalMoney(), 0);
    }

    @DisplayName("상금 총합 출력 테스트")
    @Test
    void calculateTotalResultTest() {
        LottoGameService lottoGameService = new LottoGameService();

        List<Lotto> lottos = new ArrayList<>();
        List<Integer> winningNumbers = new ArrayList<>();
        Integer bonusNumber = 7;

        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)));

        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Assertions.assertEquals(
            lottoGameService.calculateTotalResult(lottos, winningNumbers, bonusNumber)
                .getTotalMoney(), 2000005000);
    }
}
