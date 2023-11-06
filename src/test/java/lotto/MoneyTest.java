package lotto;

import static lotto.ErrorMessage.INDIVISIBLE_NUMBER;
import static lotto.ErrorMessage.NOT_NUMBER_FORMAT;
import static lotto.ErrorMessage.ZERO_NUMBER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.controller.LottoManager;
import lotto.model.Money;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @AfterEach
    void setDown() {
        Console.close();
    }

    @DisplayName("돈을 성공 적으로 입력 받았습니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000"})
    void receiveMoney(String validMoney) {
        // given
        LottoManager lottoManager = new LottoManager();
        // when
        InputStream readLine = setReadLine(validMoney);
        System.setIn(readLine);
        // then
        assertDoesNotThrow(lottoManager::receiveMoney);
    }


    @DisplayName("[Error] 나누어 떨이지지 않는 돈이 입력 되면 예외가 발생한다.")
    @Test
    void receiveMoneyByIndivisibleNumber() {
        // given
        String invalidMoney = "1050";

        // when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Money(invalidMoney));

        // then
        assertThat(exception.getMessage()).isEqualTo(INDIVISIBLE_NUMBER.getMessage());
    }

    @DisplayName("[Error] 돈 0원이 입력 되면 예외가 발생 한다.")
    @Test
    void receiveMoneyByZero() {
        // given
        String invalidMoney = "0";

        // when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Money(invalidMoney));

        // then
        assertThat(exception.getMessage()).isEqualTo(ZERO_NUMBER.getMessage());
    }

    @DisplayName("[Error] 돈이 숫자 형태가 아니면 예외가 발생한다.")
    @Test
    void receiveMoneyByNotNumber() {
        // given
        String invalidMoney = "1000b";

        // when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Money(invalidMoney));

        // then
        assertThat(exception.getMessage()).isEqualTo(NOT_NUMBER_FORMAT.getMessage());
    }

    public static InputStream setReadLine(String readLine) {
        return new ByteArrayInputStream(readLine.getBytes());
    }
}
