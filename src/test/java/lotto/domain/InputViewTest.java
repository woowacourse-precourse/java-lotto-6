package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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