package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class TypeChangerTest {
    @Test
    void 쉼표를_기준으로_분리한다() {
        assertThat(TypeChanger.stringToList("1,2,3,4,5,6")).isEqualTo(List.of("1","2","3","4","5","6"));
    }
}
