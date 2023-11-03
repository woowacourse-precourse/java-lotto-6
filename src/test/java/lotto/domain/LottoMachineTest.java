package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("당첨 번호가 입력되지 않으면 예외가 발생한다.")
    @Test
    void createWiningNumbersByEmpty() {
        assertThatThrownBy(() -> lottoMachine.drawWiningNumbers(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 값이 없습니다.");
    }

    @DisplayName("당첨 번호에 공백이 있으면 예외가 발생한다.")
    @Test
    void createWiningNumbersByBlack() {
        assertThatThrownBy(() -> lottoMachine.drawWiningNumbers("1, 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 공백 없이 쉼표(,)로 구분된 숫자로만 입력해주세요.");
    }

    @DisplayName("당첨 번호가 쉼표를 제외하고 숫자가 아니면 예외가 발생한다.")
    @Test
    void createWiningNumbersByNotNumber() {
        assertThatThrownBy(() -> lottoMachine.drawWiningNumbers("a,b,c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 공백 없이 쉼표(,)로 구분된 숫자로만 입력해주세요.");
    }

    @DisplayName("당첨 번호 중 빈 값이 있으면 예외가 발생한다.")
    @Test
    void createWiningNumbersByNoValue() {
        assertThatThrownBy(() -> lottoMachine.drawWiningNumbers("1,2,3,,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력되지 않은 번호가 있습니다.");
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWiningNumbersByOverSize() {
        assertThatThrownBy(() -> lottoMachine.drawWiningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개 여야 합니다.");
    }

    @DisplayName("당첨 번호의 개수가 6개 보다 적으면 예외가 발생한다.")
    @Test
    void createWiningNumbersByUnderSize() {
        assertThatThrownBy(() -> lottoMachine.drawWiningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개 여야 합니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWiningNumbersByDuplicateNumber() {
        assertThatThrownBy(() -> lottoMachine.drawWiningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
    }

    @DisplayName("당첨 번호의 숫자 범위가 1~45가 아닌 경우 예외가 발생한다.")
    @Test
    void createWiningNumbersByOverRange() {
        assertThatThrownBy(() -> lottoMachine.drawWiningNumbers("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 입력되지 않으면 예외가 발생한다.")
    @Test
    void createBonusNumbersByEmpty() {
        assertThatThrownBy(() -> lottoMachine.drawBonusNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 값이 없습니다.");
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumbersByNotNumber() {
        assertThatThrownBy(() -> lottoMachine.drawBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @DisplayName("보너스 번호의 숫자 범위가 1~45가 아닌 경우 예외가 발생한다.")
    @Test
    void createBonusNumbersByOverRange() {
        assertThatThrownBy(() -> lottoMachine.drawBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumbersByDuplicateWiningNumber() {
        lottoMachine.drawWiningNumbers("1,2,3,4,5,6");
        assertThatThrownBy(() -> lottoMachine.drawBonusNumber("6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }
}