package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    private final Lotto winnerLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    private final Lotto userLotto = new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16));

    @DisplayName("보너스 번호의 숫자가 로또 번호 범위 밖일 때 예외처리한다.")
    @Test
    void throwExceptionWhenBonusNumberIsOutOfRange() {
        assertThatThrownBy(() -> {
            BonusNumber bonusNumber = new BonusNumber(winnerLotto, 46);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 숫자가 당첨 번호에 포함 될 때 예외처리한다.")
    @Test
    void throwExceptionWhenBonusNumberIsPartOfWinnerNumber() {
        assertThatThrownBy(() -> {
            BonusNumber bonusNumber = new BonusNumber(winnerLotto, 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 유저 로또 번호에 포함되면 True를 반환한다")
    @Test
    void returnTrueWhenBonusNumberIsPartOfUserLotto() {
        BonusNumber bonusNumber = new BonusNumber(winnerLotto, 11);
        assertTrue(bonusNumber.isPartOf(userLotto));
    }

    @DisplayName("보너스 번호가 유저 로또 번호에 포함되지 않으면 False를 반환한다")
    @Test
    void returnFalseWhenBonusNumberIsNotPartOfUserLotto() {
        BonusNumber bonusNumber = new BonusNumber(winnerLotto, 17);
        assertFalse(bonusNumber.isPartOf(userLotto));
    }

}
