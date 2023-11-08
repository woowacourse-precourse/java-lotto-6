package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class BuyerTest extends IOTest {
    private Buyer buyer;

    @BeforeEach
    void setUp() {
        super.setUp();
        buyer = new Buyer();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }



    @DisplayName("로또 구입 금액 테스트1")
    @Test
    void 숫자인지() {
        systemIn("1000j");
        buyer.takeLottoPurchaseAmountFromBuyer();
        assertThat(getOutput()).contains("[ERROR] 숫자가 아닙니다.");
    }

    @DisplayName("로또 구입 금액 테스트2")
    @Test
    void 천원단위인지 () {
        systemIn("23");
        buyer.getLottoPurchaseAmount();
        assertThat(getOutput()).contains("[ERROR] 천원단위로 입력해주세요.");
    }


}