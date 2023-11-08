package lotto.ui;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConsoleInputTest {
    @AfterEach
    void cleanConsole() {
        Console.close();
    }

    @ParameterizedTest
    @CsvSource(value = {"3", "11", "10000", "10000000"})
    @DisplayName("로또 구입금액 사용자 입력")
    void 로또_구입금액_사용자_입력(String userInput) {
        //given
        final byte[] buf = userInput.getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        //when
        Input input = new ConsoleInput();
        int price = input.getPrice();

        //then
        assertThat(price).isEqualTo(Integer.parseInt(userInput));
    }
}