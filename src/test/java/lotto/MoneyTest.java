package lotto;

import static lotto.ErrorMessage.INDIVISIBLE_NUMBER;
import static lotto.ErrorMessage.NOT_NUMBER_FORMAT;
import static lotto.ErrorMessage.ZERO_NUMBER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import lotto.controller.LottoManager;
import lotto.model.Money;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
        Console.close();
    }


    @DisplayName("[Error] 나누어 떨이지지 않는 돈이 입력 되면 에러 메세지를 출력합니다.")
    @Test
    void receiveMoneyByIndivisibleNumber() {
        // given
        String invalidMoney = "1050";

        // when
        Money.createMoney(invalidMoney);

        // then
        assertThat(outputMessage.toString()).contains("[ERROR]");
    }

    @DisplayName("[Error] 돈 0원이 입력 되면 에러 메세지를 출력합니다")
    @Test
    void receiveMoneyByZero() {
        // given
        String invalidMoney = "0";

        // when
        Money.createMoney(invalidMoney);

        // then
        assertThat(outputMessage.toString()).contains("[ERROR]");
    }

    @DisplayName("[Error] 돈이 숫자 형태가 아니면 에러 메세지를 출력합니다")
    @Test
    void receiveMoneyByNotNumber() {
        // given
        String invalidMoney = "1000b";

        // when
        Money.createMoney(invalidMoney);

        // then
        assertThat(outputMessage.toString()).contains("[ERROR]");
    }

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }
}
