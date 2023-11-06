package domain;

import lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoProfitCalculatorTest {

    LottoProfitCalculator lottoProfitCalculator;
    @BeforeEach
    void setUp() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        List<Integer> firstPrizeNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> secondPrizeNumbers = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> thirdPrizeNumbers = List.of(1, 2, 3, 4, 5, 8);
        List<Integer> fourthPrizeNumbers = List.of(1, 2, 3, 4, 8, 9);
        List<Integer> fifthPrizeNumbers = List.of(1, 2, 3, 8, 9, 10);
        List<Integer> noPrizeNumbers = List.of(8, 9, 10, 11, 12, 13);

        List<Lotto> lottos = List.of(
                new Lotto(firstPrizeNumbers),
                new Lotto(firstPrizeNumbers),
                new Lotto(secondPrizeNumbers),
                new Lotto(thirdPrizeNumbers),
                new Lotto(fourthPrizeNumbers),
                new Lotto(fifthPrizeNumbers),
                new Lotto(noPrizeNumbers)
        );

        for (int i = 0; i < lottos.size(); i++) {
            LottoWinChecker lottoWinChecker = new LottoWinChecker(lottos.get(i), winningNumbers);
        }

        lottoProfitCalculator = new LottoProfitCalculator(7000, lottos);
    }

    @DisplayName("setRankCount의 결과가 모든 등수에 대해 1개씩 나오는지 확인한다.")
    @Test
    void testSetRankCount() {
        lottoProfitCalculator.setRankCount();
        int[] actual = lottoProfitCalculator.rankCount;
        int[] expected = {1, 1, 1, 1, 2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @DisplayName("rankPrinter의 반환 값이 예상과 동일한지 확인한다.")
    @Test
    void testRankPrinter() {
        String actual = lottoProfitCalculator.rankPrinter();
        String expected = "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 1개\n" +
                "5개 일치 (1,500,000원) - 1개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                "6개 일치 (2,000,000,000원) - 2개\n";

        Assertions.assertEquals(expected, actual);
    }

    @DisplayName("큰 숫자를 처리 가능한 지 여부와 소수점 첫째 자리까지 출력되는지 확인한다.")
    @Test
    void testProfitCalculator() {
        String actual = lottoProfitCalculator.getProfitRate();
        String expected = "57593642.9";

        Assertions.assertEquals(expected, actual);
    }
}