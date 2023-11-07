package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConverterTest {

    @DisplayName("입력 값이 숫자가 아니면 오류가 발생한다.")
    @Test
    void inputNotNumber(){
        assertThatThrownBy(() -> Converter.stringToList("1,2,3,4,오"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 양의 정수가 아니면 오류가 발생한다.")
    @Test
    void inputFloat(){
        assertThatThrownBy(() -> Converter.stringToList("1.2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 비어 있으면 오류가 발생한다.")
    @Test
    void inputNull(){
        assertThatThrownBy(() -> Converter.stringToList(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
