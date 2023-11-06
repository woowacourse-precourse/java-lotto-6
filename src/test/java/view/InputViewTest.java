package view;

import camp.nextstep.edu.missionutils.Console;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("구매 금액 입력이 잘 되는지 검사")
    @Test
    void readPrice() {
        System.setIn(createUserInput("123"));
        Assertions.assertThat(InputView.enterPrice()).isEqualTo("123");
    }

    @DisplayName("로또 당첨 번호 입력이 잘 되는지 검사")
    @Test
    void readWinningNumber() {
        System.setIn(createUserInput("1,2,3,4,5,6"));
        Assertions.assertThat(InputView.enterWinningNumbers()).isEqualTo("1,2,3,4,5,6");
    }

    @DisplayName("로또 보너스 번호 입력이 잘 되는지 검사")
    @Test
    void readBonusNumber() {
        System.setIn(createUserInput("5"));
        Assertions.assertThat(InputView.enterBonusNumbers()).isEqualTo("5");
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}