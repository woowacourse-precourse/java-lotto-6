package lotto.domain;

import lotto.config.LottoRank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    @DisplayName("로또 등수별 당첨갯수")
    void getCount() {
        Result result = new Result(new ArrayList<>(List.of(0, 1, 2, 3, 4, 5)));

        assertThat(result.getCount(LottoRank.FIRST.getNum())).isEqualTo(1);
        assertThat(result.getCount(LottoRank.SECOND.getNum())).isEqualTo(2);
        assertThat(result.getCount(LottoRank.THIRD.getNum())).isEqualTo(3);
        assertThat(result.getCount(LottoRank.FOURTH.getNum())).isEqualTo(4);
        assertThat(result.getCount(LottoRank.FIFTH.getNum())).isEqualTo(5);
    }

    @Test
    @DisplayName("수익률 계산")
    void getProfitPercentage() {
        Result result = new Result(new ArrayList<>(List.of(0, 0, 0, 0, 0, 1)));

        assertThat(result.getProfitPercentage(5000)).isEqualTo(100.0);
    }
}