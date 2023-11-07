package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TestStringClass {
    @Nested
    @DisplayName("문자열 분리 테스트")
    class TestSplit {
        private static final String REGEX = ",";

        @DisplayName("주어진 REGEX를 기준으로 분리한 문자열 배열을 반환한다.")
        @Test
        void testSplit() {
            // given
            String input = "1,2";

            // when
            String[] splits = input.split(REGEX);

            // then
            assertThat(splits).contains("1", "2")
                    .containsExactly("1", "2");
        }

        @DisplayName("REGEX가 존재하지 않으면 단일 원소 배열을 반환한다.")
        @Test
        void testSplitSingleString() {
            // given
            String input = "1";

            // when
            String[] splits = input.split(REGEX);

            // then
            assertThat(splits).contains("1")
                    .containsExactly("1");
        }
    }

    
}
