package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ResultTest {

    @DisplayName("ranking이 주어지면 결과 값을 수정할 수 있다.")
    @Test
    void put() {
        Result result = new Result();
        result.put(Ranking.SECOND);
        assertAll(
                () ->assertThat(result.getResult().get(Ranking.SECOND)).isEqualTo(1),
                () ->assertThat(result.getResult().get(Ranking.FIRST)).isEqualTo(0)
        );
    }

}