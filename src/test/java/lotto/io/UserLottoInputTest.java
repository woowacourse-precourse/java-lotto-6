package lotto.io;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import lotto.exception.InvalidMoneyInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserLottoInputTest {
    public void setupInputStream(String inputString) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(byteArrayInputStream);
    }

    @ParameterizedTest
    @ValueSource(strings = {"100b", "1000 ", "10 a"})
    @DisplayName("올바르지 않은 돈 입력이 들어오면 예외를 발생한다.")
    public void invalidMoneyInput(String in) {
        setupInputStream(in);
        UserLottoInput input = new UserLottoInput();

        assertThatThrownBy(() -> input.getMoneyAmount())
                .isInstanceOf(InvalidMoneyInput.class);
    }

    @AfterEach
    public void tearDown() {
        Console.close();
    }
}
