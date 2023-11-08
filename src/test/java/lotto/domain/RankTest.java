package lotto.domain;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @DisplayName("당첨 등급의 상금을 정상적으로 가져올 수 있다.")
    @Test
    void getPrize() {
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000);
        assertThat(Rank.SECOND.getPrize()).isEqualTo(30_000_000);
        assertThat(Rank.THIRD.getPrize()).isEqualTo(1_500_000);
        assertThat(Rank.FOURTH.getPrize()).isEqualTo(50_000);
        assertThat(Rank.FIFTH.getPrize()).isEqualTo(5_000);
        assertThat(Rank.MISS.getPrize()).isEqualTo(0);
    }

    @DisplayName("당첨 등급의 일치 숫자 개수를 정상적으로 가져올 수 있다.")
    @Test
    void getCountOfMatch() {
        assertThat(Rank.FIRST.getCountOfMatch()).isEqualTo(6);
        assertThat(Rank.SECOND.getCountOfMatch()).isEqualTo(5);
        assertThat(Rank.THIRD.getCountOfMatch()).isEqualTo(5);
        assertThat(Rank.FOURTH.getCountOfMatch()).isEqualTo(4);
        assertThat(Rank.FIFTH.getCountOfMatch()).isEqualTo(3);
        assertThat(Rank.MISS.getCountOfMatch()).isEqualTo(0);
    }

    @DisplayName("당첨 등급이 보너스 볼 일치 여부를 정상적으로 가져올 수 있다.")
    @Test
    void isMatchBonus() {
        assertThat(Rank.FIRST.isMatchBonus()).isEqualTo(false);
        assertThat(Rank.SECOND.isMatchBonus()).isEqualTo(true);
        assertThat(Rank.THIRD.isMatchBonus()).isEqualTo(false);
        assertThat(Rank.FOURTH.isMatchBonus()).isEqualTo(false);
        assertThat(Rank.FIFTH.isMatchBonus()).isEqualTo(false);
        assertThat(Rank.MISS.isMatchBonus()).isEqualTo(false);
    }

    @DisplayName("일치 숫자 개수와 보너스 볼 일치 여부에 따라 해당하는 등급을 가져올 수 있다.")
    @Test
    void valueOf() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS);
    }

}