package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class IntegerParsingTest {

    @Test
    void parseInt_정상적인경우() {
        String input = "2000";

        int parsed = Integer.parseInt(input);

        assertThat(parsed).isEqualTo(2000);
    }

    @Test
    void parseInt_NumberFormatException_발생() {
        String input = "2000a";

        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(NumberFormatException.class);
    }
}
