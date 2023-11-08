package lotto.common;

import lotto.common.Converter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConverterTest {

    @DisplayName("List에 대한 입력 값이 숫자가 아니면 오류가 발생한다.")
    @Test
    void inputNotNumber_List(){
        assertThatThrownBy(() -> Converter.stringToList("1,2,3,4,오"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("List에 대한 입력 값이 정수가 아니면 오류가 발생한다.")
    @Test
    void inputFloat_List(){
        assertThatThrownBy(() -> Converter.stringToList("1.2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("List에 대한 입력 값이 비어 있으면 오류가 발생한다.")
    @Test
    void inputNull_List(){
        assertThatThrownBy(() -> Converter.stringToList(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액 입력 시 값이 비어 있으면 오류가 발생한다.")
    @Test
    void inputNull_Integer(){
        assertThatThrownBy(() -> Converter.stringToInteger(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액 입력 시 숫자가 아니면 오류가 발생한다.")
    @Test
    void inputNotNumber_Integer(){
        assertThatThrownBy(() -> Converter.stringToInteger("천"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
