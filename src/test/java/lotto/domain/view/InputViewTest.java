package lotto.domain.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("입력 받은 숫자 문자열을 숫자 타입으로 변환한다.")
    @Test
    void convertToInt() {
        //Given
        String input = "5000";
        InputView inputView = new InputView();
        //When
        int number = inputView.convertToInt(input);
        //Then
        assertThat(number).isEqualTo(5000);
    }
}