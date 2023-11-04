package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 정보 테스트")
class WinningNumbersTest {

    @DisplayName("보너스 번호와 당첨 번호가 충돌하면 검증에 실패한다")
    @Test
    void testBonusNumberConflictWithLottoNumbers() {
        List<LottoNumber> winningLottoNumbers = new ArrayList<>();
        winningLottoNumbers.add(LottoNumber.from(1));
        winningLottoNumbers.add(LottoNumber.from(2));
        winningLottoNumbers.add(LottoNumber.from(3));
        winningLottoNumbers.add(LottoNumber.from(7));
        winningLottoNumbers.add(LottoNumber.from(8));
        winningLottoNumbers.add(LottoNumber.from(9));
        Lotto winningLotto = Lotto.from(winningLottoNumbers);
        LottoNumber bonusNumber = LottoNumber.from(1);
        assertThatThrownBy(() -> WinningNumbers.of(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_CONFLICT.getErrorMessage());
    }

    @DisplayName("보너스 번호가 일치하는 지 확인할 수 있다")
    @Test
    void testBonusNumberHit() {
        List<LottoNumber> winningLottoNumbers = new ArrayList<>();
        winningLottoNumbers.add(LottoNumber.from(1));
        winningLottoNumbers.add(LottoNumber.from(2));
        winningLottoNumbers.add(LottoNumber.from(3));
        winningLottoNumbers.add(LottoNumber.from(7));
        winningLottoNumbers.add(LottoNumber.from(8));
        winningLottoNumbers.add(LottoNumber.from(9));
        Lotto winningLotto = Lotto.from(winningLottoNumbers);
        LottoNumber bonusNumber = LottoNumber.from(15);
        WinningNumbers winningNumbers = WinningNumbers.of(winningLotto, bonusNumber);

        assertThat(winningNumbers.bonusNumberMatch(LottoNumber.from(15))).isTrue();
    }

    @DisplayName("당첨 번호와 일치하는 번호의 개수를 계산할 수 있다")
    @Test
    void testMatchingNumberCountWithWinningNumbers() {
        List<LottoNumber> winningLottoNumbers = new ArrayList<>();
        winningLottoNumbers.add(LottoNumber.from(1));
        winningLottoNumbers.add(LottoNumber.from(2));
        winningLottoNumbers.add(LottoNumber.from(3));
        winningLottoNumbers.add(LottoNumber.from(7));
        winningLottoNumbers.add(LottoNumber.from(8));
        winningLottoNumbers.add(LottoNumber.from(9));
        Lotto winningLotto = Lotto.from(winningLottoNumbers);
        LottoNumber bonusNumber = LottoNumber.from(15);
        WinningNumbers winningNumbers = WinningNumbers.of(winningLotto, bonusNumber);

        List<LottoNumber> lotto = new ArrayList<>();
        lotto.add(LottoNumber.from(1));
        lotto.add(LottoNumber.from(2));
        lotto.add(LottoNumber.from(3));
        lotto.add(LottoNumber.from(5));
        lotto.add(LottoNumber.from(6));
        lotto.add(LottoNumber.from(9));
        Lotto issuedLotto = Lotto.from(lotto);

        int matchingNumberCount = winningNumbers.countMatchingNumber(issuedLotto);
        assertThat(matchingNumberCount).isEqualTo(4);
    }
}