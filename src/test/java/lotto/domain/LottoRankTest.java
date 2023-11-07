package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.LottoRank;
import lotto.model.LottoRankInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @DisplayName("LottoRank enum static 메서드 valueOf 정상 생성 테스트")
    @Test
    void valueOf_EqualResult_success() {

        //given
        long matchCount = 5L;
        Boolean bonusBall = true;

        //when
        LottoRank result = LottoRank.valueOf(matchCount, bonusBall);

        //then
        assertThat(result).isEqualTo(LottoRank.SECOND);

    }
}
