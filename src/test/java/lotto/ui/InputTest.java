package lotto.ui;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputTest {

    @DisplayName("사용자 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "1,2,3,4,5,6", "7"})
    void get(String userInput) {
        // given
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        // when, then
        assertThat(Input.get()).isEqualTo(userInput);

        Console.close();
    }
}