package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinningLotto 클래스")
class WinningLottoTest {

    private WinningLotto winningLotto;
    private List<Integer> winningNumbers;
    private BonusNumber bonusNumber;

    @BeforeEach
    void setup() {
        winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        bonusNumber = BonusNumber.from(7);
        winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복된다면 예외를 발생한다.")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        BonusNumber duplicatedBonusBonusNumber = BonusNumber.from(6);
        assertThatThrownBy(() -> WinningLotto.of(winningNumbers, duplicatedBonusBonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 당첨 여부를 판단한다.")
    @Test
    void compareLottoNumbersToWinningNumbers() {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.matches(lotto)).isEqualTo(LottoPrize.FIRST);
    }
}