package lotto.resource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class TextFormatTest {

    @Test
    void formatTest() {
        TextFormat tf = new TextFormat("[%s, %s, %s]");
        assertThat(tf.format("1","2","3"))
                .isEqualTo("[1, 2, 3]" );
    }

    @Test
    void parseTest(){
        TextFormat tf = new TextFormat("[%s, %s, %s]");
        assertThat(tf.parse("[1, 2, 3]"))
                .isEqualTo(List.of("1","2","3"));
    }
}
