package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    @DisplayName("정수가 아닌 값 입력 시 예외처리 후 재입력")
    void inputNotInteger() {
        String[] inputs = {"5000j", "5000"};
        System.setIn(new ByteArrayInputStream(String.join("\n", inputs).getBytes()));
        Money money = Money.createMoney();
        assertThat(output()).contains("[ERROR] 잘못된 금액을 입력했습니다.");
        assertEquals(money.getMoney(), 5000);
    }

    @Test
    @DisplayName("1000으로 나누어 떨어지지 않는 값 입력 시 예외처리 후 재입력")
    void inputNot1000Multiples() {
        String[] inputs = {"5001", "5000"};
        System.setIn(new ByteArrayInputStream(String.join("\n", inputs).getBytes()));
        Money money = Money.createMoney();
        assertThat(output()).contains("[ERROR] 잘못된 금액을 입력했습니다.");
        assertEquals(money.getMoney(), 5000);
    }

    @Test
    @DisplayName("Money 생성 테스트")
    void createMoneyTest() {
        Money money = new Money(5000);
        assertEquals(money.getMoney(), 5000);
    }

}