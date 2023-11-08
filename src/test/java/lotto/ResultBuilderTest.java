package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultBuilderTest {

    @DisplayName("받은 결과 배열를 문자열 형태로 반환")
    @Test
    void buildStringResult() {
        ResultBuilder resultBuilder = new ResultBuilder();
        int[] result = new int[]{1, 0, 0, 0, 0};
        String expected = "3개 일치 (5,000원) - 1개";

        assertThat(resultBuilder.resultBuild(result)).contains(expected);
    }

}