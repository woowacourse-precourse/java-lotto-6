package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @DisplayName("정상 파싱 테스트")
    @Test
    void parserTest(){
        assertThat(Parser.parseToInt("4")).isEqualTo(4);
    }

    @DisplayName("파싱 예외 테스트")
    @Test
    void parserExceptionTest(){
        assertThatThrownBy(() -> Parser.parseToInt("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}