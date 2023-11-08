package function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.LottoPlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class LottoPlayerTest {
    private LottoPlayer player;
    private ByteArrayOutputStream outputCaptor;

    @BeforeEach
    void setUp() {
        player = new LottoPlayer();
        outputCaptor = new ByteArrayOutputStream();
    }

    @Test
    void buyLottosTest() {
        try (MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            given(Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                    .willReturn(List.of(1,2,3,4,5,6));

            System.setOut(new PrintStream(outputCaptor));
            player.buyLottos(5);

            assertEquals("5개를 구매했습니다." + "\r\n[1, 2, 3, 4, 5, 6]".repeat(5),
                    outputCaptor.toString().strip());
        }
    }

    @Test
    void printRateOfProfitTest() {
        player.buyLottos(1);
        player.addMoney(5000);

        System.setOut(new PrintStream(outputCaptor));
        player.printRateOfProfit(1000);

        assertEquals("총 수익률은 500.0%입니다.", outputCaptor.toString().strip());
    }

    @Test
    void addMoneyTest() {
        player.addMoney(1000);
        player.addMoney(2000);
        player.addMoney(5000);

        assertEquals(player.getMoney(), 8000);
    }
}
