package lotto;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("구매자 기능 테스트")
class BuyerTest {

    @DisplayName("성공: 구매자는 금액을 입력할 수 있다.")
    @Test
    void test1() {
        LottoMachine lottoMachine = new LottoMachine();
        Buyer buyer = new Buyer(lottoMachine);
        System.setIn(new ByteArrayInputStream("8000".getBytes()));
        buyer.buyLotto();
    }
}