package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {
    WinningNumber winningNumber;

    @BeforeEach
    void setUp(){
        winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
    }


    @DisplayName("[EXCEPTION]보너스 번호가 당첨 번호와 중복 사용된 경우 예외가 발생한다.")
    @Test
    void createBonusNumberByUsedInWinningNumber() {
        assertThatThrownBy(() -> new BonusNumber(winningNumber,6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호에 사용되지 않은 숫자여야 합니다.");
    }


    @DisplayName("[EXCEPTION]보너스 번호가 잘못된 범위의 숫자인 경우 예외가 발생한다.")
    @Test
    void createBonusNumberByWrongRangeNumber() {
        assertThatThrownBy(() -> new BonusNumber(winningNumber,46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }


    @DisplayName("[SUCCESS]보너스 번호가 로또에 존재할 경우 true를 반환한다.")
    @Test
    void checkBonusNumberInLotto(){
        // given
        BonusNumber bonusNumber = new BonusNumber(winningNumber, 7);

        // when
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        // when, then
        assertThat(bonusNumber.isHitBonusNumber(lotto))
                .isEqualTo(true);
    }

    @DisplayName("[SUCCESS]보너스 번호가 로또에 존재하지 않을 경우 false를 반환한다.")
    @Test
    void checkBonusNumberNotInLotto(){
        // given
        BonusNumber bonusNumber = new BonusNumber(winningNumber, 7);

        // when
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when, then
        assertThat(bonusNumber.isHitBonusNumber(lotto))
                .isEqualTo(false);
    }

}