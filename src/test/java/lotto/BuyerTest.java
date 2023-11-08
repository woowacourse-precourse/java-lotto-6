package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("구매자 기능 테스트")
class BuyerTest {

    @DisplayName("성공: 구매자는 금액을 입력할 수 있다.")
    @Test
    void test1() {
        LottoMachine lottoMachine = new LottoMachine();
        LottoResultChecker lottoResultChecker = new LottoResultChecker();
        Buyer buyer = new Buyer(lottoMachine, lottoResultChecker);
        System.setIn(new ByteArrayInputStream("8000".getBytes()));

        assertThatCode(buyer::buyLotto)
                .doesNotThrowAnyException();
        Console.close();
    }
}