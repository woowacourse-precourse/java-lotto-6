package service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.service.WinningLottoFactory;
import lotto.service.WinningLottoFactoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberFactoryTest {
    WinningLottoFactory winningLottoFactory = WinningLottoFactoryImpl.getInstance();

    Lotto makeLotto() {
        String inputNumber = "1,2,3,4,5,6";
        Lotto lotto = winningLottoFactory.winningLotto(inputNumber);
        return lotto;
    }
    @Test
    @DisplayName("보너스 숫자 생성 테스트")
    void bonusNumber() {
        String inputBonusNumber = "12";
        BonusNumber bonusNumber = winningLottoFactory.bonusNumber(inputBonusNumber, makeLotto());
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(12);
    }

    @Test
    @DisplayName("보너스 숫자 생성 개수 예외 테스트")
    void bonusNumberFailWithSize() {
        String inputBonusNumber = "12,1";
        assertThatThrownBy(() -> winningLottoFactory.bonusNumber(inputBonusNumber, makeLotto()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자 생성 범위 초과 예외 테스트")
    void bonusNumberFailWithRangeOver() {
        String inputBonusNumber = "100";
        assertThatThrownBy(() -> winningLottoFactory.bonusNumber(inputBonusNumber, makeLotto()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자 생성 범위 미만 예외 테스트")
    void bonusNumberFailWithRangeUnder() {
        String inputBonusNumber = "0";
        assertThatThrownBy(() -> winningLottoFactory.bonusNumber(inputBonusNumber, makeLotto()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자 중복 예외 테스트")
    void bonusNumberFailWithDup() {
        String inputBonusNumber = "6";
        assertThatThrownBy(() -> winningLottoFactory.bonusNumber(inputBonusNumber, makeLotto()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
