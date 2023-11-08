package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @DisplayName("결과를 생성하면 0으로 초기화 된다.")
    @Test
    void createResult() {
        Result result = new Result();
        Assertions.assertThat(result.getCount(Score.FIRST)).isEqualTo(0);
        Assertions.assertThat(result.getCount(Score.SECOND)).isEqualTo(0);
        Assertions.assertThat(result.getCount(Score.THIRD)).isEqualTo(0);
        Assertions.assertThat(result.getCount(Score.FOURTH)).isEqualTo(0);
        Assertions.assertThat(result.getCount(Score.FIFTH)).isEqualTo(0);
        Assertions.assertThat(result.getCount(Score.NONE)).isEqualTo(0);
    }

    @DisplayName("count 메서드를 이용하여 결과를 변경할 수 있다.")
    @Test
    void countResult() {
        Result result = new Result();
        result.count(Score.FIRST);
        result.count(Score.SECOND);
        result.count(Score.SECOND);
        result.count(Score.THIRD);
        result.count(Score.THIRD);
        result.count(Score.THIRD);
        result.count(Score.FOURTH);
        result.count(Score.FOURTH);
        result.count(Score.FOURTH);
        result.count(Score.FOURTH);
        result.count(Score.FIFTH);
        result.count(Score.FIFTH);
        result.count(Score.FIFTH);
        result.count(Score.FIFTH);
        result.count(Score.FIFTH);
        Assertions.assertThat(result.getCount(Score.FIRST)).isEqualTo(1);
        Assertions.assertThat(result.getCount(Score.SECOND)).isEqualTo(2);
        Assertions.assertThat(result.getCount(Score.THIRD)).isEqualTo(3);
        Assertions.assertThat(result.getCount(Score.FOURTH)).isEqualTo(4);
        Assertions.assertThat(result.getCount(Score.FIFTH)).isEqualTo(5);
        Assertions.assertThat(result.getCount(Score.NONE)).isEqualTo(0);
    }

}