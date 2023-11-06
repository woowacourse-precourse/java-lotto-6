package lotto.domain;

import lotto.enums.LottoEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static lotto.enums.LottoEnum.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void resultCount() {
        // given
        Result.resultCount(W1);
        Result.resultCount(null);

        // when
        int total = Result.getTotal();

        // then
        assertThat(Result.getCount(W1)).isEqualTo(1);
        assertThat(Result.getCount(W2)).isEqualTo(0);
        assertThat(Result.getCount(W3)).isEqualTo(0);
        assertThat(Result.getCount(W4)).isEqualTo(0);
        assertThat(Result.getCount(W5)).isEqualTo(0);

        assertThat(total).isEqualTo(W1.getReward());

    }
}