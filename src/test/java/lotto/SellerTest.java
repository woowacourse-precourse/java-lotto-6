package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class SellerTest extends NsTest {

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @DisplayName("1000원 단위 입력 시 티켓 개수가 정상적으로 반환되는지 확인한다.")
    @Test
    void tc1() {
        // given
        Seller seller = new Seller();

        // when
        systemStdIn("3000");
        int ticketCount = seller.sellTickets();

        // then
        Assertions.assertThat(ticketCount).isEqualTo(3);
    }

    @DisplayName("1000원 단위가 아닐 시, 재입력 요청 메시지가 출력되는지 확인한다.")
    @Test
    void tc2() {
        // given
        Seller seller = new Seller();

        // when
        systemStdIn("3500", "3000");
        int ticketCount = seller.sellTickets();

        // then
        Assertions.assertThat(output()).contains("[ERROR] 1,000원 단위로 입력해 주세요.");
        Assertions.assertThat(ticketCount).isEqualTo(3);
    }

    @DisplayName("숫자가 아닐 시, 재입력 요청 메시지가 출력되는지 확인한다.")
    @Test
    void tc3() {
        // given
        Seller seller = new Seller();

        // when
        systemStdIn("3500q", "3000");
        int ticketCount = seller.sellTickets();

        // then
        Assertions.assertThat(output()).contains("[ERROR] 숫자만 입력해 주세요.");
        Assertions.assertThat(ticketCount).isEqualTo(3);
    }

    private void systemStdIn(String... inputs) {
        String data = String.join("\n", inputs);
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Override
    protected void runMain() {

    }
}
