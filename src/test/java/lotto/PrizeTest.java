package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PrizeTest extends NsTest {
    @DisplayName("로또번호가 맞는지 확인한다.")
    @Test
    public void makePrizeRanks() {
        List<Integer> prizeNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Prize prize = new Prize(prizeNumbers, bonusNumber);

        Buyer buyer = new Buyer(1000);
        Lotto firstPlaceLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondPlaceLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        buyer.getLotteries().add(firstPlaceLotto);
        buyer.getLotteries().add(secondPlaceLotto);

        HashMap<Rank, Integer> rankCounts = prize.makePrizeRanks(buyer);

        assertEquals(1, rankCounts.get(Rank.FIRST));
        assertEquals(1, rankCounts.get(Rank.SECOND));
        assertEquals(0, rankCounts.get(Rank.THIRD));
        assertEquals(0, rankCounts.get(Rank.FOURTH));
        assertEquals(0, rankCounts.get(Rank.FIFTH));
    }

    @DisplayName("보너스번호를 확인한다.")
    @Test
    public void containBonusNumber() {
        List<Integer> numbersWithBonus = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> numbersWithoutBonus = Arrays.asList(1, 2, 3, 4, 5, 6);

        int bonusNumber = 7;
        Prize prize = new Prize(numbersWithBonus, bonusNumber);

        assertTrue(prize.isContainBonusNumber(numbersWithBonus));
        assertFalse(prize.isContainBonusNumber(numbersWithoutBonus));
    }

//    @DisplayName("당첨번호 길이를 확인한다.")
//    @Test
//    void checkLottoCount() {
//        assertSimpleTest(() -> {
//
//            Error error = Error.NOT_LOTTO_COUNT;
//            List<Integer> numbersWithBonus = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//            int bonusNumber = 8;
//            Prize prize = new Prize(numbersWithBonus, bonusNumber);
////        assertSimpleTest(() -> {
//            assertThat(output()).contains(error.getMsg());
////        });
//        });
//    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
