package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {
    @Test
    void 일치하는_개수_받아_일치하는_순위_enum_찾기() {
        String rank = "5+1";
        LottoRank result =  Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getSameCount().equals(rank))
                .findAny()
                .orElse(null);

        assertThat(result).isEqualTo(LottoRank.SECOND);
    }
}