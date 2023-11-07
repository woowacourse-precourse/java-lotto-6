package lotto.utils;

import java.util.List;
import lotto.utils.CommaParser;
import lotto.utils.Parser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @DisplayName("당첨 번호를 쉼표로 구분한다")
    @Test
    void splitWithComma() {
        String numbers = "1,2,3,4,5,6";
        Parser parser = new CommaParser();
        Assertions.assertThat(parser.split(numbers)).isEqualTo(List.of("1", "2", "3", "4", "5", "6"));
    }
}
