package lotto.purchaseTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

import static lotto.service.LottoService.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseTest {

    public void init(String input){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @ParameterizedTest
    @ValueSource(strings = {"8000"})
    @DisplayName("구입_금액에_해당하는_만큼_로또를_발행하는_테스트")
    public void purchaseAndPublishTest(String money){
        //given
        init(money);

        //when
        int wantBuyAmount = Integer.parseInt(money) / 1000;
        int purchasedAmount = enterPurchaseAmount();

        //then
        assertThat(purchasedAmount)
                .isEqualTo(wantBuyAmount);
    }

}
