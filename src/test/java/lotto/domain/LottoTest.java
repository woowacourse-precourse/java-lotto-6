package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {


    @DisplayName("로또는 범위내 중복없는 6자리 숫자로 만들어진다.")
    @Test
    void createLottoWithWrongValues() {
        assertAll(
                () -> assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3))).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 67, 68, 69))).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 3, 4, 5))).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("보너스 번호화 로또 번호는 중복될 수 없다.")
    @Test
    void lottoNumberAndBonusNumberDuplicate() {
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> lotto.contain(6)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호화 로또 번호를 비교하며 동일한 숫자의 갯수를 반환한다.")
    @Test
    void matchedNumberCount() {
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = WinningLotto.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)), BonusBall.valueOf(23));

        assertThat(6).isEqualTo(winningLotto.getMatchedCountCompareTo(lotto));
    }

    @DisplayName("로또 번호와 중복되는 보너스 번호가 있다면 True를 반환한다.")
    @Test
    void lottoContainsBonusNumber() {
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));

        BonusBall bonusBall = BonusBall.valueOf(5);

        assertThat(lotto.contains(bonusBall)).isTrue();
    }

}