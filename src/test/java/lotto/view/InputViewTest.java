package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @DisplayName("String이 존재하면 예외가 발생한다.")
    @Test
    void parseToInput() {
        assertThatThrownBy(() -> InputView.parseToInt("1000j") )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Blank가 존재하면 예외가 발생한다.")
    @Test
    void isBlank() {
        assertThatThrownBy(() -> InputView.parseToInt("") )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("스페이스가 존재하면 예외가 발생한다.")
    @Test
    void isBlankWitnSpace() {
        assertThatThrownBy(() -> InputView.parseToInt(" ") )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표가 맨 앞에 존재하면 예외가 발생한다.")
    @Test
    void splitInput_DelimiterStart() {
        assertThatThrownBy(() -> InputView.splitInput(",1,2,3,4,5,6") )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표가 맨 뒤에 존재하면 예외가 발생한다.")
    @Test
    void splitInput_DelimiterEnd() {
        assertThatThrownBy(() -> InputView.splitInput("1,2,3,4,5,6,") )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표가 붙어있으면 예외가 발생한다.")
    @Test
    void splitInput_Blank() {
        assertThatThrownBy(() -> InputView.splitInput("1,2,,4,5,6") )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표 사이에 공백이 존재하면 예외가 발생한다.")
    @Test
    void splitInput_BlankSpace() {
        assertThatThrownBy(() -> InputView.splitInput("1,2, ,4,5,6") )
                .isInstanceOf(IllegalArgumentException.class);
    }
}