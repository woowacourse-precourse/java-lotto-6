package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Winning;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningTest {
	@DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinnningByOverSize() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
	
	@DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningByDuplicatedNumber() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 범위 밖에 있으면 예외가 발생한다.")
    @Test
    void createWinningOutOfRange() {
        assertThatThrownBy(() -> new Winning(List.of(46, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("보너스 번호가 범위 밖에 있으면 예외가 발생한다.")
    @Test
    void createBonusOutOfRange() {
        assertThatThrownBy(() -> new Winning(List.of(1,2,3,4,5,6)).setBonus(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("보너스 번호가 당첨 번호에 중복이 예외가 발생한다.")
    @Test
    void createBonusDuplicate() {
        assertThatThrownBy(() -> new Winning(List.of(1,2,3,4,5,6)).setBonus(6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}