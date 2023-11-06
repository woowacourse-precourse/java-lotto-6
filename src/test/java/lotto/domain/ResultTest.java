package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.enums.LottoEnum.*;
import static org.assertj.core.api.Assertions.*;

class ResultTest {


    @Test
    void resultCount() {
        // given
        Result result = new Result();
        result.resultCount(W1);
        result.resultCount(null);

        // when
        int total = result.getTotal();

        // then
        assertThat(result.getCount(W1)).isEqualTo(1);
        assertThat(result.getCount(W2)).isEqualTo(0);
        assertThat(result.getCount(W3)).isEqualTo(0);
        assertThat(result.getCount(W4)).isEqualTo(0);
        assertThat(result.getCount(W5)).isEqualTo(0);

        assertThat(total).isEqualTo(W1.getReward());

    }
}