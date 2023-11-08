package lotto.utils;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @DisplayName("당첨 번호를 쉼표로 구분한다")
    @Test
    void splitWithComma() {
        //given
        String numbers = "1,2,3,4,5,6";

        //when
        Parser parser = new CommaParser();

        //then
        Assertions.assertThat(parser.split(numbers)).isEqualTo(List.of("1", "2", "3", "4", "5", "6"));
    }
}
