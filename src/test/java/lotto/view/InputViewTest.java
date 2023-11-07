package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private InputView inputView;
    
    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }
    
    @AfterEach
    void closeConsole() {
        Console.close();
    }
    
    @DisplayName("로또 구입 금액 입력 시, 숫자 이외의 다른 문자는 입력이 불가하다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "!@#", " ", ""})
    void inputAmountOnlyDigit(String userInput) {
        // given
        System.setIn(createUserInput(userInput));
        
        // when // then
        assertThatThrownBy(() -> inputView.inputAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    
    private InputStream createUserInput(String input) {
        if (input.isEmpty()) {
            input = "empty";
        }
        return new ByteArrayInputStream(input.getBytes());
    }
}
