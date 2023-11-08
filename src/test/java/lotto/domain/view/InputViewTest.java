package lotto.domain.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("입력 받은 숫자 문자열을 숫자 타입으로 변환한다.")
    @Test
    void convertToInt() {
        //Given
        String input = "5000";
        //When
        int number = inputView.convertToInt(input);
        //Then
        assertThat(number).isEqualTo(5000);
    }

    @Test
    void convertToIntByNotNumber() {
        assertThatThrownBy(() -> inputView.convertToInt("aaa1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력하실 수 있습니다.");
    }
}