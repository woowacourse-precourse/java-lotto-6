package lotto.Domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    @DisplayName("당첨 번호의 갯수가 6이면 FIRST")
    void hitSix() {
        int hitNumber = 6;
        boolean isHitBonus = false;

        Assertions.assertThat(Rank.FIRST.hit(hitNumber,isHitBonus)).isTrue();
    }
    @Test
    @DisplayName("당첨 번호의 갯수가 5이고 보너스 번호를 맞췄다면 SECOND")
    void hitFiveAndBonus() {
        int hitNumber = 5;
        boolean isHitBonus = true;

        Assertions.assertThat(Rank.SECOND.hit(hitNumber,isHitBonus)).isTrue();
    }
    @Test
    @DisplayName("당첨 번호의 갯수가 5이고 보너스 번호를 맞추지 못했다면 THIRD")
    void hitFive() {
        int hitNumber = 5;
        boolean isHitBonus = false;

        Assertions.assertThat(Rank.THIRD.hit(hitNumber,isHitBonus)).isTrue();
    }
    @Test
    @DisplayName("당첨 번호의 갯수가 4이면 FOURTH")
    void hitFour() {
        int hitNumber = 4;
        boolean isHitBonus = false;

        Assertions.assertThat(Rank.FOURTH.hit(hitNumber,isHitBonus)).isTrue();
    }
    @Test
    @DisplayName("당첨 번호의 갯수가 3이면 FIFTH")
    void hitThree() {
        int hitNumber = 3;
        boolean isHitBonus = false;

        Assertions.assertThat(Rank.FIFTH.hit(hitNumber,isHitBonus)).isTrue();
    }
    @Test
    @DisplayName("당첨 번호의 갯수가 2이면 NOTHING")
    void hitTwo() {
        int hitNumber = 2;
        boolean isHitBonus = false;

        Assertions.assertThat(Rank.NOTHING.hit(hitNumber,isHitBonus)).isTrue();
    }

}