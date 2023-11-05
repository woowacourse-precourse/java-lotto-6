package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.Objects;
import lotto.buy.Buy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class BuyTest {
    private final Buy buy = new Buy(2000000L,2000L);
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    protected final void run(String a,final String... args) {
        try {
            command(args);
            runMain(a);
        } finally {
            Console.close();
        }
    }
    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    void runMain(String a){
        if(Objects.equals(a, "RequestBuyMoney")) {
            buy.RequestBuyMoney();
        }
        if(Objects.equals(a, "PrintLottoIssuanceNumber")){
            buy.PrintLottoIssuanceNumber();
        }
    }
    @DisplayName("정상 입력")
    @Test
    void RequestBuyMoney_MultipleRead_테스트() {
        //give
        long Money = 2000000L;
        long IssuanceNumber = 2000L;
        //when
        assertTimeoutPreemptively(Duration.ofSeconds(1L),() -> {
            run("RequestBuyMoney", "2000000");
        });
        //then
        assertEquals(buy.GetBuyMoney(),Money);
        assertEquals(buy.GetLottoIssuanceNumber(),IssuanceNumber);
    }

    @DisplayName("정상범위의 입력에 따른 정상적인 출력")
    @Test
    void SetBuy_GetBuy_테스트() {
        //given
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
        assertTimeoutPreemptively(Duration.ofSeconds(1L),() -> {
            run("PrintLottoIssuanceNumber");
            assertThat(output()).contains("2000개를 구매했습니다.");
        });
    }
}
