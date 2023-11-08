package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static lotto.constant.ErrorMessage.DUPLICATED_BONUS;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningLottoTest {

    @DisplayName("당첨 번호와 보너스 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedNumber() {
        Lotto lottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(6);
        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_BONUS);
    }

    @DisplayName("당첨 번호와 내 로또 번호가 얼마나 일치하는 지 셀 수 있다.")
    @Test
    void countCorrectNumber() {
        Lotto lottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(lottoNumbers, bonusNumber);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        int countMatchNumbers = winningLotto.countMatchNumbers(userLotto);
        assertThat(countMatchNumbers).isEqualTo(3);
    }
}