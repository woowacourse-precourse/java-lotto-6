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
        Buyer buyer = new Buyer(lottoMachine);
        System.setIn(new ByteArrayInputStream("8000".getBytes()));
        
        assertThatCode(buyer::buyLotto)
                .doesNotThrowAnyException();
        Console.close();
    }

    @DisplayName("성공: 구매자는 당첨 번호를 생성할 수 있다.")
    @Test
    void test2() {
        LottoMachine lottoMachine = new LottoMachine();
        Buyer buyer = new Buyer(lottoMachine);
        System.setIn(new ByteArrayInputStream("1,2,3,4,5,6\n7".getBytes()));

        assertThatCode(buyer::drawWinningNumbersAndBonusNumber)
                .doesNotThrowAnyException();
        Console.close();
    }

    @DisplayName("성공: 구매자는 로또를 확인할 수 있다.")
    @Test
    void test3() {
        LottoMachine lottoMachine = new LottoMachine();
        Buyer buyer = new Buyer(lottoMachine);

        System.setIn(new ByteArrayInputStream("8000\n1,2,3,4,5,6\n7".getBytes()));
        assertThatCode(buyer::buyLotto)
                .doesNotThrowAnyException();

        buyer.drawWinningNumbersAndBonusNumber();

        System.out.println(buyer.getLotto());
        Console.close();
    }

    @DisplayName("성공: 구매자는 당첨 번호를 확인할 수 있다.")
    @Test
    void test4() {
        LottoMachine lottoMachine = new LottoMachine();
        Buyer buyer = new Buyer(lottoMachine);

        System.setIn(new ByteArrayInputStream("8000\n1,2,3,4,5,6\n7".getBytes()));
        assertThatCode(buyer::buyLotto)
                .doesNotThrowAnyException();

        buyer.drawWinningNumbersAndBonusNumber();

        System.out.println(buyer.getDrawnNumbers());
        Console.close();
    }
}