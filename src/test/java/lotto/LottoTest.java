package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호와 당첨 번호간 일치 하는 숫자를 계산한다.")
    @Test
    void countMatchingNumberWithWinningNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = WinningNumber.from(List.of(1, 2, 3, 4, 5, 6));

        long count = lotto.countMatchingNumber(winningNumber);

        assertThat(count).isEqualTo(6);


        Lotto lotto2 = new Lotto(List.of(11, 12, 13, 14, 15, 16));

        long count2 = lotto2.countMatchingNumber(winningNumber);

        assertThat(count2).isEqualTo(0);
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있는지 판단한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void verifyIsBonusNumberIncludedShouldPass(int bonusNumberValue) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = WinningNumber.from(List.of(11, 12, 13, 14, 15, 16));
        BonusNumber bonusNumber = new BonusNumber(bonusNumberValue, winningNumber);

        boolean result = lotto.contains(bonusNumber);

        assertThat(result).isTrue();
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있는지 판단한다.")
    @ParameterizedTest
    @ValueSource(ints = {40, 41, 42, 43, 44, 45})
    void verifyIsBonusNumberIncludedShouldFail(int bonusNumberValue) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = WinningNumber.from(List.of(11, 12, 13, 14, 15, 16));
        BonusNumber bonusNumber = new BonusNumber(bonusNumberValue, winningNumber);

        boolean result = lotto.contains(bonusNumber);

        assertThat(result).isFalse();
    }
}