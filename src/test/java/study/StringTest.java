package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("String.split(): 구분자가 포함되어 있는 경우")
    void givenWithComma_whenSplitByComma_thenReturnCorrectValue() {
        String oneAndTwo = "1,2";

        String[] result = oneAndTwo.split(",");

        assertThat(result).contains("1", Index.atIndex(0));
        assertThat(result).contains("2", Assertions.atIndex(1));
        assertThat(result).contains("1", "2");
        assertThat(result).contains("2", "1");
        assertThat(result).contains("1", "2", "1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String.split(): 구분자가 없는 경우")
    void givenWithoutComma_whenSplitByComma_thenReturnCorrectValue() {
        String one = "1";

        String[] result = one.split(",");

        assertThat(result).contains("1");
        assertThat(result).contains("1", Index.atIndex(0));
        assertThat(result).containsExactly("1");
        assertThat(result.length).isOne();
    }

}
