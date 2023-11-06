package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LotteryServiceTest {
    static final int PRIZE_INDEX = 0;
    LotteryService lotteryService = new LotteryService();

    @DisplayName("입력한 복권수만큼 복권 객체를 리스트에 담아 반환한다.")
    @Test
    void getLotteryListSizeAsLotteryCount(){
        int exampleLotteryCount1 = 1;
        List<Lotto> resultLotteryList1 = lotteryService.getTotalLottery(exampleLotteryCount1);
        int resultLotteryCount1 = resultLotteryList1.size();

        assertEquals(exampleLotteryCount1, resultLotteryCount1);

        int exampleLotteryCount2 = 2;
        List<Lotto> resultLotteryList2 = lotteryService.getTotalLottery(exampleLotteryCount2);
        int resultLotteryCount2 = resultLotteryList2.size();

        assertEquals(exampleLotteryCount2, resultLotteryCount2);
    }

    @DisplayName("복권의 숫자와 당첨숫자가 일치하는 만큼 Count를 반환한다.")
    @Test
    void increaseCountByOneWhenLotteryNumberHasWinningNumber(){
        List<Integer> exampleLotteryNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto exampleWinningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        int resultSameNumberCount = lotteryService.getSameNumberCount(exampleLotteryNumber, exampleWinningNumber);
        int expectedSameNumberCount = 6;

        assertEquals(expectedSameNumberCount, resultSameNumberCount);

        List<Integer> exampleLotteryNumber2 = Arrays.asList(6, 5, 4, 3, 2, 1);
        Lotto exampleWinningNumber2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        int resultSameNumberCount2 = lotteryService.getSameNumberCount(exampleLotteryNumber2, exampleWinningNumber2);
        int expectedSameNumberCount2 = 6;

        assertEquals(expectedSameNumberCount2, resultSameNumberCount2);

    }

    @Test
    void findSecondPrizeOfWhichSameNumberCountEquals5AndOfWhichHasBonusNumberEqualsTrue(){
        int exampleSameNumberCount = 5;
        boolean exampleHasBonusNumber = true;

        String resultPrize = lotteryService.getRank(exampleSameNumberCount, exampleHasBonusNumber).name();
        String expectedPrize = "SECOND_PRIZE";

        assertEquals(expectedPrize, resultPrize);
    }

    @DisplayName("입력한 당첨 번호와 6자리가 모두 일치하는 1등 복권을 복권 리스트에서 찾는다.")
    @Test
    void findTheFirstPrizeInLotteryListThatAllNumberIsSameAsWinningNumber(){
        List<Lotto> exampleLotteries = new ArrayList<>();
        exampleLotteries.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto exampleWinningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int exampleBonusNumber = 7;
        String expectedPrize = "FIRST_PRIZE";

        assertPrize(exampleLotteries, exampleWinningLotto, exampleBonusNumber, expectedPrize);

        List<Lotto> exampleLotteries2 = new ArrayList<>();
        exampleLotteries2.add(new Lotto(Arrays.asList(7, 2, 3, 4, 5, 1)));
        Lotto exampleWinningLotto2 = new Lotto(Arrays.asList(7, 2, 3, 4, 5, 1));
        int exampleBonusNumber2 = 8;
        String expectedPrize2 = "FIRST_PRIZE";

        assertPrize(exampleLotteries2, exampleWinningLotto2, exampleBonusNumber2, expectedPrize2);
    }

    @DisplayName("입력한 당첨 번호와 5자리가 일치하고 나머지 번호는 보너스 번호와 일치하는 2등 복권을 복권 리스트에서 찾는다.")
    @Test
    void findTheSecondPrizeInLotteryListThatHasFiveNumberWhichIsSameAsNumberInWinningNumbeAndHasOneNumberWhichIsSameAsBonusNumber() {
        List<Lotto> exampleLotteries = new ArrayList<>();
        exampleLotteries.add(new Lotto(Arrays.asList(1, 7, 3, 4, 5, 6)));
        Lotto exampleWinningLotto = new Lotto(Arrays.asList(3, 4, 6, 5, 7, 2));
        int exampleBonusNumber = 1;
        String expectedPrize = "SECOND_PRIZE";

        assertPrize(exampleLotteries, exampleWinningLotto, exampleBonusNumber, expectedPrize);
    }

    @DisplayName("입력한 당첨 번호와 5자리가 일치하고 나머지 번호는 보너스 번호와 일치하지 않는 3등 복권을 복권 리스트에서 찾는다.")
    @Test
    void findTheThirdPrizeInLotteryListThatHasFiveNumberWhichIsSameAsNumberInWinningNumbeAndHasOneNumberWhichIsNotSameAsBonusNumber(){
        List<Lotto> exampleLotteries = new ArrayList<>();
        exampleLotteries.add(new Lotto(Arrays.asList(1, 7, 3, 4, 5, 6)));
        Lotto exampleWinningLotto = new Lotto(Arrays.asList(3, 4, 6, 5, 7, 2));
        int exampleBonusNumber = 9;
        String expectedPrize = "THIRD_PRIZE";

        assertPrize(exampleLotteries, exampleWinningLotto, exampleBonusNumber, expectedPrize);
    }

    @DisplayName("입력한 당첨 번호와 4자리가 일치하는 4등 복권을 복권 리스트에서 찾는다.")
    @Test
    void findTheFourthPrizeInLotteryListThatHasFourNumberWhichIsSameAsNumberInWinningNumber(){
        List<Lotto> exampleLotteries = new ArrayList<>();
        exampleLotteries.add(new Lotto(Arrays.asList(1, 7, 3, 4, 5, 6)));
        Lotto exampleWinningLotto = new Lotto(Arrays.asList(3, 4, 6, 5, 8, 9));
        int exampleBonusNumber = 7;
        String expectedPrize = "FOURTH_PRIZE";

        assertPrize(exampleLotteries, exampleWinningLotto, exampleBonusNumber, expectedPrize);
    }

    @DisplayName("입력한 당첨 번호와 3자리가 일치하는 5등 복권을 복권 리스트에서 찾는다.")
    @Test
    void findTheFifthPrizeInLotteryListThatHasThreeNumberWhichIsSameAsNumberInWinningNumber(){
        List<Lotto> exampleLotteries = new ArrayList<>();
        exampleLotteries.add(new Lotto(Arrays.asList(1, 7, 3, 4, 5, 6)));

        Lotto exampleWinningLotto = new Lotto(Arrays.asList(3, 24, 6, 5, 8, 9));
        int exampleBonusNumber = 1;
        String expectedPrize = "FIFTH_PRIZE";

        assertPrize(exampleLotteries, exampleWinningLotto, exampleBonusNumber, expectedPrize);
    }

    @DisplayName("1등 복권과 3등 복권과 낙첨 복권이 포함된 복권 리스트를 판별한다.")
    @Test
    void findTheFirstPrizeTheThirdPrizeAndFailureInLotteryList(){
        List<Lotto> exampleLotteries = new ArrayList<>();
        exampleLotteries.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        exampleLotteries.add(new Lotto(Arrays.asList(6, 5, 4, 3, 2, 11)));
        exampleLotteries.add(new Lotto(Arrays.asList(1, 2, 31, 32, 7, 37)));

        Lotto exampleWinningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int exampleBonusNumber = 7;

        List<Ranking> resultWinningInformation = lotteryService.compareLotteryWithWinningNumber(exampleLotteries, exampleWinningLotto, exampleBonusNumber);
        assertThat(resultWinningInformation).contains(Ranking.FAILURE, Ranking.THIRD_PRIZE, Ranking.FIRST_PRIZE);
        assertThat(resultWinningInformation).containsExactly(Ranking.FIRST_PRIZE, Ranking.THIRD_PRIZE, Ranking.FAILURE);
    }

    private void assertPrize(List<Lotto> lotteries, Lotto winningNumber, int bonusNumber, String expectedPrize){
        List<Ranking> resultWinningInformation = lotteryService.compareLotteryWithWinningNumber(lotteries, winningNumber, bonusNumber);
        String resultPrize = resultWinningInformation.get(PRIZE_INDEX).name();

        assertEquals(expectedPrize, resultPrize);
    }
}
