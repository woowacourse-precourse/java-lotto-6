package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberSplitterTest {
    @DisplayName("번호 분리 성공시 분리된 번호가 담긴 리스트 반환")
    @Test
    void success() {
        // give
        String input = "1,2,3,5,10,24";
        // when
        List<String> numberSplit = NumberSplitter.splitNumbers(input);
        //then
        assertThat(numberSplit).contains("1", "2", "3", "5", "10", "24");
    }
}