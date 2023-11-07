package lotto.domainTest;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import lotto.domain.Rank;
import lotto.domain.Result;

public class ResultTest {

    @Test
    @DisplayName("Result 배열에 Rank가 올바르게 저장된다")
    void lottoOrderedTest() {
        Result result = new Result(Rank.valueOf(5, false));
        Rank rank = Rank.valueOf(6, true);
        result.add(rank);

        Assertions.assertThat(result.getResults()).contains(Rank.valueOf(6, true));
    }
}

