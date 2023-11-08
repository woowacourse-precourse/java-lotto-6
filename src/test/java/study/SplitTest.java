package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SplitTest {

    @DisplayName("split 함수 테스트 해보기")
    @Test
    void split_정상적인경우() {
        String input = "1,2,3,4,5,6";

        List<Integer> numbers = Stream.of(input.split(","))
                .map(Integer::parseInt)
                .toList();

        assertThat(numbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("split 잘못된 경우 테스트 해보기")
    @Test
    void split_숫자가_아닌_문자가_있는경우() {
        String input = "1,2,3,4,a,6";

        assertThatThrownBy(
                () -> Stream.of(input.split(","))
                        .map(Integer::parseInt)
                        .toList())
                .isInstanceOf(NumberFormatException.class);
    }
}
