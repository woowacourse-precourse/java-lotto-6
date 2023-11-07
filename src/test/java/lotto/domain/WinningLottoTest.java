package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @DisplayName("로또 번호와 보너스 번호가 주어지면 WinningLotto 객체를 생성한다.")
    @Test
    void createWinningLotto() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Lotto winningLottoNumbers = new Lotto(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        assertThat(winningLotto.getWinningNumbers().getNumbers()).isEqualTo(winningNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("로또 번호가 주어지면 WinningLotto 객체를 생성한다 (보너스 번호 없음).")
    @Test
    void createWinningLottoWithoutBonusNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lotto winningLottoNumbers = new Lotto(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, 0);

        assertThat(winningLotto.getWinningNumbers().getNumbers()).isEqualTo(winningNumbers);
        assertThat(winningLotto.getBonusNumber()).isZero();
    }

    @DisplayName("로또 번호와 보너스 번호가 주어지면 WinningLotto 객체를 생성한다 (보너스 번호 중복).")
    @Test
    void createWinningLottoWithDuplicateBonusNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        Lotto winningLottoNumbers = new Lotto(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        assertThat(winningLotto.getWinningNumbers().getNumbers()).isEqualTo(winningNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("로또 번호와 보너스 번호가 주어지면 WinningLotto 객체를 생성한다 (보너스 번호 중복되지 않음).")
    @Test
    void createWinningLottoWithNonDuplicateBonusNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Lotto winningLottoNumbers = new Lotto(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        assertThat(winningLotto.getWinningNumbers().getNumbers()).isEqualTo(winningNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }
}
