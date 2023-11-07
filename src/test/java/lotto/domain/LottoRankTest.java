package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.LottoRank;
import lotto.model.LottoRankInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @DisplayName("valueOf SECOND 정상 생성 테스트")
    @Test
    void valueOf_EqualSECOND_success() {

        //given
        long matchCount = 5L;
        Boolean bonusBall = true;

        //when
        LottoRank result = LottoRank.valueOf(matchCount, bonusBall);

        //then
        assertThat(result).isEqualTo(LottoRank.SECOND);
        assertThat(result).isNotNull();

    }

    @DisplayName("valueOf NONE 정상 생성 테스트")
    @Test
    void valueOf_EqualNONE_success() {

        //given
        long matchCount = 2L;
        Boolean bonusBall = true;

        //when
        LottoRank result = LottoRank.valueOf(matchCount, bonusBall);

        //then
        assertThat(result).isEqualTo(LottoRank.NONE);

    }

    @DisplayName("valueOf FIRST 정상 생성 테스트")
    @Test
    void valueOf_EqualFIRST_success() {

        //given
        long matchCount = 6L;
        Boolean bonusBall = true;

        //when
        LottoRank result = LottoRank.valueOf(matchCount, bonusBall);

        //then
        assertThat(result).isEqualTo(LottoRank.FIRST);

    }


}
