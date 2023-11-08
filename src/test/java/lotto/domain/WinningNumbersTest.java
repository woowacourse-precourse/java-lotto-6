package lotto.domain;

import static lotto.testutils.LottoCreator.createLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 정보 테스트")
class WinningNumbersTest {
    @DisplayName("보너스 번호와 당첨 번호가 충돌하면 검증에 실패한다")
    @Test
    void testBonusNumberConflictWithLottoNumbers() {
        Lotto winningLotto = createLotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.from(1);
        assertThatThrownBy(() -> WinningNumbers.of(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_CONFLICT.getErrorMessage());
    }

    @DisplayName("보너스 번호가 일치하는 지 확인할 수 있다")
    @Test
    void testBonusNumberHit() {
        Lotto winningLotto = createLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto issuedLotto = createLotto(List.of(1, 2, 3, 4, 5, 15));
        LottoNumber bonusNumber = LottoNumber.from(15);
        WinningNumbers winningNumbers = WinningNumbers.of(winningLotto, bonusNumber);
        assertThat(winningNumbers.bonusNumberMatch(issuedLotto)).isTrue();
    }

    @DisplayName("당첨 번호와 전달 로또의 일치하는 번호 개수를 계산할 수 있다")
    @Test
    void testMatchingNumberCountWithWinningNumbers() {
        Lotto winningLotto = createLotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.from(15);
        WinningNumbers winningNumbers = WinningNumbers.of(winningLotto, bonusNumber);
        Lotto issuedLotto = createLotto(List.of(1, 2, 3, 4, 9, 10));
        int matchingNumberCount = winningNumbers.countMatchingNumber(issuedLotto);
        assertThat(matchingNumberCount).isEqualTo(4);
    }
}