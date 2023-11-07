package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 주어졌을 때, 로또 번호가 일치하는 개수를 반환한다.")
    @Test
    void matchLottoNumbers() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto myLotto = new Lotto(List.of(1, 2, 5, 7, 8, 10));

        assertSimpleTest(() -> {
            int matchCount = myLotto.countMatchingNumbers(winningLotto.getLotto());
            assertThat(matchCount).isEqualTo(3);
        });
    }

    @DisplayName("보너스 번호가 주어졌을 때, 보너스 번호가 존재하면 true를 반환한다.")
    @Test
    void matchBonusNumber() {
        int bonusNumber = 8;
        Lotto myLotto = new Lotto(List.of(1, 2, 5, 7, 8, 10));

        assertSimpleTest(() -> {
            boolean hasBonusNumber = myLotto.hasBonusNumber(bonusNumber);
            assertThat(hasBonusNumber).isEqualTo(true);
        });
    }

    @DisplayName("보너스 번호가 주어졌을 때, 보너스 번호가 존재하지 않으면 false를 반환한다.")
    @Test
    void notMatchBonusNumber() {
        int bonusNumber = 24;
        Lotto myLotto = new Lotto(List.of(1, 2, 5, 7, 8, 10));

        assertSimpleTest(() -> {
            boolean hasBonusNumber = myLotto.hasBonusNumber(bonusNumber);
            assertThat(hasBonusNumber).isEqualTo(false);
        });
    }
}