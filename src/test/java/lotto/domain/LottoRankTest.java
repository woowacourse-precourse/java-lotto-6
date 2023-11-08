package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {

    @DisplayName("맞춘 로또 번호의 개수와 보너스 번호를 맞췄는지 여부에 맞게 상금을 계산한다.")
    @Test
    void calculate() {
        // given
        int correctCount = 5;
        boolean isSameBonus = true;
        LottoRank rank = LottoRank.calculate(correctCount, isSameBonus);

        // when
        int amount = rank.getAmount();

        // then
        int expected = 30_000_000;
        Assertions.assertThat(amount).isEqualTo(expected);
    }
}