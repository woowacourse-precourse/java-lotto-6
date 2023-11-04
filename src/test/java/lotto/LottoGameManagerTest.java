package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoGameManagerTest {

    @Test
    @DisplayName("로또 구입 금액 입력")
    public void testInputPurchaseAmount() {
        LottoGameManager manager = new LottoGameManager();
        String amount = "1000";
        InputStream inputStream = new ByteArrayInputStream(amount.getBytes());
        System.setIn(inputStream);
        int purchaseAmount = manager.inputPurchaseAmount();

        assertEquals(1000, purchaseAmount);
    }
}
