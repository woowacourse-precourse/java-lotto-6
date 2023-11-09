package lotto.purchase.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseTest {

    @AfterEach
    public void closeConsoleEach() {
        Console.close();
    }

    @DisplayName("로또 구입 금액이 숫자이지 않으면 예외가 발생한다.")
    @Test
    void 숫자가_아닌_로또_구매_금액() {
        Purchase purchase = new Purchase();
        String input = "2000a\n2000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        purchase.insult();

        assertThat(out.toString()).contains("[ERROR]");
    }

    @DisplayName("로또 구입 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void 나누어_떨어지지_않는_구매_금액() {
        Purchase purchase = new Purchase();
        String input = "2001";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        purchase.insult();

        assertThatThrownBy(() -> purchase.calculate()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액을 1000으로 나눈 구매 개수를 반환한다.")
    @Test
    void 금액에_따른_로또_구매_개수_반환() {
        Purchase purchase = new Purchase();
        String input = "14000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        purchase.insult();
        purchase.calculate();

        assertThat(purchase.getPurchaseAmount()).isEqualTo(14);
    }

}
