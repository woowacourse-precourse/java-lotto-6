package lotto.purchaseTest;

import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class purchaseFunctionTest {

    @Test
    @DisplayName("구입_금액에_해당하는_만큼_로또를_발행하는_테스트")
    public void purchaseAndPublishTest(){
        //given
        String money = "8000";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(money.getBytes());
        System.setIn(in);
        int wantBuyAmount = 8;
        int purchasedAmount = LottoService.enterPurchaseAmount();
        //when

        //then
        assertThat(purchasedAmount)
                .isEqualTo(wantBuyAmount);
    }

}
