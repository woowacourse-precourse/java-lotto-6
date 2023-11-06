package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    @DisplayName("맞춘 개수 5, 보너스 번호 일치 할시 2등(SECOND)를 반환해야한다.")
    void getSecondRankTest() {
        // given
        int count = 5;
        Boolean hasbonusNumber = true;
        // when
        LottoRank lottoRank = LottoRank.of(count, hasbonusNumber);
        // then
        Assertions.assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("맞춘 개수 4, 보너스 번호 일치 할시 4등(THIRD)을 반환해야한다.")
    void getFourthRankTest1() {
        // given
        int count = 4;
        Boolean hasbonusNumber = true;
        // when
        LottoRank lottoRank = LottoRank.of(count, hasbonusNumber);
        // then
        Assertions.assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("맞춘 개수 4, 보너스 번호 일치 안할시 4등(THIRD)을 반환해야한다.")
    void getFourthRankTest2() {
        // given
        int count = 4;
        Boolean hasbonusNumber = false;
        // when
        LottoRank lottoRank = LottoRank.of(count, hasbonusNumber);
        // then
        Assertions.assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }

}