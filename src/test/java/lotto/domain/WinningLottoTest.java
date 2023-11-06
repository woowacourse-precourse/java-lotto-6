package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.enums.LottoPrize;
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
        bonusNumber = new BonusNumber(7);
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복된다면 예외를 발생한다.")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        BonusNumber duplicatedBonusBonusNumber = new BonusNumber(6);
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, duplicatedBonusBonusNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교하여 당첨 여부를 판단한다.")
    @Test
    void compareLottoNumbersToWinningNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.matches(lotto)).isEqualTo(LottoPrize.FIRST);
    }
}