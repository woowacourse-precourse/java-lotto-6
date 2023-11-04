package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LotteryServiceTest {
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
}
