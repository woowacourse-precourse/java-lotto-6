package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import java.util.List;
import lotto.model.WinningNumber;
import lotto.record.LottoNumberRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class WinningNumberTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호중 하나라도 숫자가 아니면 예외가 발생한다.")
    void winningNumberNotInteger() {
        assertThatThrownBy(() -> new WinningNumber("가,나,다,4,a,b", "0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "보너스"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 1 ~ 45 사이가 아니면 예외가 발생한다.")
    void BonusNumberUnderOrOver() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "47"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void duplicateWinningNumberAndBonusNumber() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void countMatchingNumbers() {
        assertSimpleTest(() -> assertThat(new WinningNumber("1,2,3,4,5,6", "7")
                .countMatchingNumbers(new LottoNumberRecord(List.of(1,2,3,4,5,6))))
                .isEqualTo(6));
    }

    @Test
    void hasMatchingBonusNumber() {
        assertSimpleTest(() -> assertThat(new WinningNumber("1,2,3,4,5,6", "7")
                .hasMatchingBonusNumber(new LottoNumberRecord(List.of(1,2,3,4,5,7)))).isTrue());
    }
}