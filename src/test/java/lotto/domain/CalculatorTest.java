package lotto.domain;

import static lotto.utils.constants.LottoConstants.LOTTO_TICKET_PRICE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    WinningNumbers winningNumbers;
    List<Lotto> winningLottos = new ArrayList<>();

    List<Ranking> rankingList;

    @BeforeEach
    void setUp() {
        Integer[] numbers = {1, 3, 5, 7, 9, 11};
        Lotto winningLotto = new Lotto(Arrays.asList(numbers));
        BonusNumber bonusNumber = new BonusNumber(40, winningLotto);
        winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        Integer[] firstNumbers = new Integer[]{1, 3, 5, 7, 9, 11};
        Integer[] secondNumbers = new Integer[]{1, 3, 5, 7, 9, 40};
        Integer[] thirdNumbers = new Integer[]{1, 3, 5, 7, 9, 30};
        Integer[] fourthNumbers = new Integer[]{1, 3, 5, 7, 10, 20};
        Integer[] fifthNumbers = new Integer[]{1, 3, 5, 10, 20, 30};
        Integer[] noneNumbers = new Integer[]{31, 32, 33, 34, 35, 36};

        List<Integer[]> testNumbers = new ArrayList<>();
        testNumbers.add(noneNumbers);
        testNumbers.add(fifthNumbers);
        testNumbers.add(fourthNumbers);
        testNumbers.add(thirdNumbers);
        testNumbers.add(secondNumbers);
        testNumbers.add(firstNumbers);

        testNumbers.stream()
                .forEach((lotto) -> winningLottos.add(new Lotto(Arrays.asList(lotto))));

        rankingList = Arrays.asList(Ranking.values());
    }


    @Test
    void 등수_반환_테스트() {
        Calculator calculator = new Calculator();
        for (int i = 0; i < winningLottos.size(); i++) {
            Ranking ranking = calculator.calculateRanking(winningLottos.get(i), winningNumbers);
            Assertions.assertThat(ranking).isEqualTo(rankingList.get(i));
        }
    }

    @Test
    void 수익률_반환_테스트() {
        Calculator calculator = new Calculator();
        Map<Ranking, Integer> board = new TreeMap<>();
        board.put(Ranking.None, 10);
        board.put(Ranking.Fifth, 3);
        board.put(Ranking.Fourth, 2);
        board.put(Ranking.Third, 1);
        board.put(Ranking.Second, 0);
        board.put(Ranking.First, 0);


        PurchaseAmount purchaseAmount = new PurchaseAmount(16000);
        float returnOfRate = calculator.calculateReturnOfRate(board, purchaseAmount);
        int totalReward = Ranking.Fifth.getReward() * 3 + Ranking.Fourth.getReward() * 2 + Ranking.Third.getReward();
        float answer = (float) totalReward / (16 * LOTTO_TICKET_PRICE) * 100;

        Assertions.assertThat(returnOfRate).isEqualTo(answer);
    }

}