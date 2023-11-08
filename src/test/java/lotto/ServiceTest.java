package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {

    @DisplayName("발행한 로또의 개수가 구매한 로또의 개수와 같은지 확인한다.")
    @Test
    void buyLottoEquals() {
        int amount = 5;
        List<Lotto> lottos = Service.buyLottos(amount);

        assertEquals(amount, lottos.size());
    }

    @DisplayName("로또 비교 결과와 당첨수량을 확인한다.")
    @Test
    void checkLottoMatchesCorrectly() {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16));
        lottos.add(lotto1);
        lottos.add(lotto2);

        String[] winningNumbers = {"1", "2", "3", "4", "5", "6"};
        int bonus = 7;

        Service.checkLottos(lottos, winningNumbers, bonus);
        assertEquals(1,LottoRank.SIX_MATCH.getAdditionalMatches());
        assertEquals(0, LottoRank.FIVE_MATCH.getAdditionalMatches());
        assertEquals(0, LottoRank.FOUR_MATCH.getAdditionalMatches());
        assertEquals(0, LottoRank.THREE_MATCH.getAdditionalMatches());
        assertEquals(0, LottoRank.FIVE_MATCH_WITH_BONUS.getAdditionalMatches());
    }

    @DisplayName("로또 비교 결과와 수익률을 확인한다.")
    @Test
    void calculateProfitRate_ShouldCalculateCorrectly() {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16));
        lottos.add(lotto1);
        lottos.add(lotto2);

        String[] winningNumbers = {"1", "2", "3", "4", "5", "6"};
        int bonus = 7;

        Service.checkLottos(lottos, winningNumbers, bonus);

        int money = 2000;
        double profitRate = Service.calculateProfitRate(money);

        assertEquals(1.0E8,profitRate);
    }
}
