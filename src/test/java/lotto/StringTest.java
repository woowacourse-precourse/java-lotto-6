package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class StringTest {
    String input = "1,2,3,4,5";
    String input2 = "1";

    @DisplayName("입력받은 문자열이 잘 분리되는지 확인하기")
    @Test
    void stringSplitTest() {
        String[] numbers = input.split(",");
        assertThat(numbers).contains("1", "2", "3", "4", "5");
        assertThat(numbers).containsExactly("1", "2", "3", "4", "5");

        String[] numbers2 = input2.split(",");
        assertThat(numbers2).contains("1");
        assertThat(numbers2).containsExactly("1");
    }
}
