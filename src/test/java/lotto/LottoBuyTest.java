package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.time.Duration;
import lotto.Controller.PrintScreen;
import lotto.Controller.Request;
import lotto.vo.buy.LottoBuy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class LottoBuyTest extends NsTest {
    private Request request = new Request();
    private PrintScreen print = new PrintScreen();
    private final LottoBuy buy = new LottoBuy(2000000L, 2000L);
    private boolean iswhat;

    @DisplayName("정상 입력")
    @Test
    void RequestBuyMoney_MultipleRead_테스트() {
        //give
        iswhat = true;
        long Money = 2000000L;
        long IssuanceNumber = 2000L;
        //when
        assertTimeoutPreemptively(Duration.ofSeconds(1L), () -> {
            run("2000000");
        });
        //then
        assertEquals(buy.GetBuyMoney(), Money);
        assertEquals(buy.GetLottoIssuanceNumber(), IssuanceNumber);
    }

    @DisplayName("정상범위의 입력에 따른 정상적인 출력")
    @Test
    void SetBuy_GetBuy_테스트() {
        //given
        iswhat = true;
        long Money = 2000000L;
        long IssuanceNumber = 2000L;
        //when
        buy.SetBuyMoney(Money);
        buy.SetlottoIssuanceNumber(IssuanceNumber);
        //then
        assertEquals(buy.GetBuyMoney(), Money);
        assertEquals(buy.GetLottoIssuanceNumber(), IssuanceNumber);
    }

    @DisplayName("몇개 구매 하였는가?")
    @Test
    void PrintLottoIssuanceNumber_테스트() {
        //given
        iswhat = false;
        long Money = 2000000L;
        long IssuanceNumber = 2000L;
        //when
        buy.SetBuyMoney(Money);
        buy.SetlottoIssuanceNumber(IssuanceNumber);
        assertTimeoutPreemptively(Duration.ofSeconds(1L), () -> {
            run();
            assertThat(output()).contains("2000개를 구매했습니다.");
        });
    }

    @Override
    public void runMain() {
        if (iswhat) {
            request.RequestBuyMoney();
        } else {
            print.PrintLottoIssuanceNumber();
        }
    }
}
