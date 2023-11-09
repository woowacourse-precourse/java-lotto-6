package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class JavaAPITest {
    @Test
    public void distinct_테스트() {
        List<String> numbers = new ArrayList<>() {{
            add("1");
            add("2");
            add("4");
            add("1");
        }};
        assertThat(numbers.stream().distinct().count()).isEqualTo(3);
    }
}
