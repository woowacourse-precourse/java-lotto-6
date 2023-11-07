package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class UserTest {


    @AfterEach
    public void consoleClose() {
        Console.close();
    }

    @Test
    @DisplayName("사용자 금액 입력 테스트 - 성공")
    public void user_input_test_success() {
        //given
        User user = new User();
        String input = "3000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        user.inputMoney();

        //then
        assertThat(user.getMoney()).isEqualTo(Integer.parseInt(input));
    }


    @Test
    @DisplayName("사용자 금액 입력 테스트(숫자가 아닌 문자) - 실패 후 입력")
    public void user_input_test_no_digit_fail() {
        //given
        User user = new User();
        String input = "1000sda\n1000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        user.inputMoney();

        //then
        assertThat(outputStream.toString()).contains("[ERROR] 숫자를 입력해야 합니다. 다시 입력하여 주세요");
        assertThat(user.getMoney()).isEqualTo(1000);
    }


    @Test
    @DisplayName("사용자 금액 입력 테스트(1000으로 떨어지지 않는 값) - 실패 후 입력")
    public void user_input_test_no_divide_fail() {
        //given
        User user = new User();
        String input = "2500\n1000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //when
        user.inputMoney();

        //then
        assertThat(outputStream.toString()).contains("[ERROR] 1000원 단위로 다시 입력하여 주세요 입력 값 = 2500");
        assertThat(user.getMoney()).isEqualTo(1000);
    }


    @Test
    @DisplayName("금액에 따른 로또 티켓 생성 - 성공")
    public void create_lotto_tickets_success() {
        //given
        User user = new User();
        String input = "3000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        user.inputMoney();

        //when
        user.createLottoTickets();
        int ticketSize = Integer.parseInt(input) / 1000;

        //then
        assertThat(user.getLottoTickets().size()).isEqualTo(ticketSize);

    }

    @Test
    @DisplayName("수익률 반환 - 성공")
    public void get_revenue_success() {
        //given
        User user = new User();
        String input = "8000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        user.inputMoney();

        //when
        double userRevenue = user.getRevenue(5000);
        double expectRevenue = (double) 5000 / 8000 * 100;

        //then
        assertThat(userRevenue).isEqualTo(expectRevenue);

    }


}