package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @DisplayName("결과 객체에서 메서드를 통해 일치하는 숫자 개수와 보너스 번호 일치 여부를 받는다.")
    @Test
    void getHitResultAndBonusResultFromResult() {
        Result mockResult = new Result(4, 0);
        assertThat(mockResult.getHitResult()).isEqualTo(4);
        assertThat(mockResult.getBonusResult()).isEqualTo(0);
    }
}
