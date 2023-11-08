package lotto.result;

import java.util.Map;
import lotto.Grade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @DisplayName("결과를 갱신할 때 이미 존재하는 키가 있다면 1을 더하고 없다면 추가한다.")
    @Test
    void addResult() {
        Result result = new Result();

        result.addResult(Grade.FIFTH);
        result.addResult(Grade.FOURTH);
        result.addResult(Grade.FOURTH);

        Map<Grade, Integer> map = result.getMap();
        Assertions.assertThat(map.get(Grade.FIFTH)).isEqualTo(1);
        Assertions.assertThat(map.get(Grade.FOURTH)).isEqualTo(2);
    }
}
