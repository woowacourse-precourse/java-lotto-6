package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    Parser parser = new Parser();


    @Test
    @DisplayName("정수로 바꾸는 테스트")
    public void testParserValidInput() {
       String inputPrice = "1000";
       int Price = parser.convertInt(inputPrice);
       assertThat(Price).isEqualTo(1000);
    }

    @Test
    @DisplayName("입력값 리스트를 제대로 구분하는가에 대한 테스트")
    public void testSplitCommaInput() {
            assertEquals(List.of("1", "2", "3"), parser.splitComma("1,2,3"));
    }
}
