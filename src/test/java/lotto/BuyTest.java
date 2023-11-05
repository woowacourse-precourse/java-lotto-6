package lotto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lotto.buy.Buy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void RequestBuyMoney_MultipleRead_테스트() {
        //given
        //when
        //then
    }

    @DisplayName("정상범위의 입력에 따른 정상적인 출력")
    @Test
    void SetBuy_GetBuy_테스트() {
        //given
        Buy buy = new Buy(0,0);
        long Money = 2000000L;
        long IssuanceNumber = 2000L;
        //when
        buy.SetBuyMoney(Money);
        buy.SetlottoIssuanceNumber(IssuanceNumber);
        //then
        assertEquals(buy.GetBuyMoney(),Money);
        assertEquals(buy.GetLottoIssuanceNumber(),IssuanceNumber);
    }


    @DisplayName("몇개 구매 하였는가?")
    @Test
    void PrintLottoIssuanceNumber_테스트() {
        //given
        System.setOut(new PrintStream(outputStreamCaptor));
        Buy buy = new Buy(2000000L,2000L);
        //when
        buy.PrintLottoIssuanceNumber();
        //then
        assertEquals("2000개를 구매했습니다.", outputStreamCaptor.toString().trim());
        System.setOut(standardOut);
    }
}
