package lotto.method.function;

import lotto.function.Parser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;


public class ParserTest {
    @Test
    @DisplayName("입력 받은 String을 int로 변환한다.")
    void stringToInt() {
        Assertions.assertThat(Parser.toInteger("123"))
                .isEqualTo(123);
    }

    @Test
    @DisplayName("입력 받은 String을 정수로 변환할 수 없으면 예외를 발생한다.")
    void stringToIntException() {
        Assertions.assertThatThrownBy(() -> Parser.toInteger("123d"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 받은 String을 쉼표(,)로 구분하여 List로 변환한다.")
    void stringToIntegerList() {
        Assertions.assertThat(Parser.toIntegerList("1,2,3,4,5,6"))
                .isInstanceOf(List.class);
        Assertions.assertThat(Parser.toIntegerList("1,2,3,4,5,6")).size()
                .isEqualTo(6);
    }

    @Test
    @DisplayName("입력 받은 String을 쉼표(,)로 구분한 각 항목들을 모두 int로 변환할 수 없으면 예외를 발샌한다.")
    void stringToIntegerListException() {
        Assertions.assertThatThrownBy(() -> Parser.toIntegerList("1,2,3,4,5,6f"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
