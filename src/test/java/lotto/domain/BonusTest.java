package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class BonusTest {

    @DisplayName("보너스 번호 범위가 1~45를 넘어가면 예외를 발생시킨다.")
    @Test
    void createLottoBonusByOutOfRange(){
        assertThatThrownBy(() -> new Bonus(60))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("보너스 번호가 존재하면 1을 리턴한다")
    @Test
    void ReturnLottoBonusByContain(){
        int value = 5;
        Bonus bonus = new Bonus(value);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(bonus.containBonusNumber(lotto)).isEqualTo(1);
    }

    @DisplayName("보너스 번호가 없으면 0을 리턴한다")
    @Test
    void ReturnLottoBonusByNotContain(){
        int value = 10;
        Bonus bonus = new Bonus(value);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(bonus.containBonusNumber(lotto)).isEqualTo(0);
    }

    @DisplayName("보너스 번호가 있으면 true")
    @Test
    void ReturnTrueIfContain() {
        int value = 1;
        Bonus bonus = new Bonus(value);
        assertThat(bonus.isContainBonusNumber(List.of(1,2,3,4,5,6))).isTrue();
    }

    @DisplayName("보너스 번호가 있으면 false")
    @Test
    void ReturnFalseIfNotContain() {
        int value = 10;
        Bonus bonus = new Bonus(value);
        assertThat(bonus.isContainBonusNumber(List.of(1,2,3,4,5,6))).isFalse();
    }
}
