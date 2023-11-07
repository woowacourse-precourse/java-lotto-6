package lotto;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoDTO;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
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

    @DisplayName("로또 객체에서 로또 번호를 DTO로 변환한다.")
    @Test
    void convertLottoToDTO() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoDTO lottoDTO = lotto.toDTO();
        assertThat(lottoDTO).isInstanceOf(LottoDTO.class);
        assertThat(lottoDTO.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 번호와 당첨 번호 일치하는 번호의 개 수를 반환한다.")
    @Test
    void matchWinningNumbersCount() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");
        WinningNumbers non = new WinningNumbers("7,8,9,10,11,12");
        assertThat(lotto.countMatchingNumbers(winNumbers)).isEqualTo(6);
        assertThat(lotto.countMatchingNumbers(non)).isEqualTo(0);
    }

    @DisplayName("보너스 번호가 로또 번호와 일치하는지 확인한다.")
    @Test
    void matchBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningNumbers winNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");
        BonusNumber bonusNumber = new BonusNumber("7", winNumbers);
        assertThat(lotto.hasMatchedBonus(bonusNumber)).isTrue();
        assertThat(lotto.hasMatchedBonus(new BonusNumber("8", winNumbers))).isFalse();
    }
}