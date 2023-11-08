package function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.LottoAdmin;
import lotto.LottoPlayer;
import lotto.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class LottoAdminTest {
    private LottoPlayer player;
    private LottoAdmin admin;
    private ByteArrayOutputStream outputCaptor;

    @BeforeEach
    void setUp() {
        player = new LottoPlayer();
        admin = new LottoAdmin();
        outputCaptor = new ByteArrayOutputStream();

        admin.setWinningNumbers(List.of(1,2,3,4,5,6));
        admin.setBonusNumber(7);
    }

    @Test
    void checkLottosTest(){
        try (MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            given(Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                    .willReturn(List.of(1, 2, 3, 4, 5, 7));

            player.buyLottos(1);

            assertEquals(admin.checkLottos(player), List.of(LottoRank.SECOND));
        }
    }

    @Test
    void payPrizeMoneyTest(){
        try (MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            given(Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                    .willReturn(List.of(1, 2, 3, 4, 7, 8));

            player.buyLottos(1);
            admin.payPrizeMoney(player);

            assertEquals(player.getMoney(), 50000);
        }
    }

    @Test
    void printPrizeTest(){
        try (MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            given(Randoms.pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt()))
                    .willReturn(List.of(1, 2, 3, 4, 5, 6));

            player.buyLottos(1);
            System.setOut(new PrintStream(outputCaptor));
            admin.printPrize(player);

            assertEquals(
                    """
                            당첨 통계
                            ---
                            3개 일치 (5,000원) - 0개
                            4개 일치 (50,000원) - 0개
                            5개 일치 (1,500,000원) - 0개
                            5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                            6개 일치 (2,000,000,000원) - 1개""",
                    outputCaptor.toString().strip());
        }
    }
}
