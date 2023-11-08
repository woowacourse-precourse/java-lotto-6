package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void inputNumbers() {
        // given
        System.setIn(createUserInput("1,2,3,4,5,6"));

        // when, then
        assertThat(InputView.inputWinningNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void inputBonusNumber() {
        // given
        System.setIn(createUserInput("1"));

        // when, then
        assertThat(InputView.inputBonusNumber()).isEqualTo(1);
    }

    InputStream createUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}