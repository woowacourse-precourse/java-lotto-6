package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    @DisplayName("당첨 번호가 입력되지 않으면 예외가 발생한다.")
    @Test
    void createWinngNumbersByEmpty() {
        assertThatThrownBy(() -> new LottoMachine("", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 값을 넣어주세요.");
    }

    @DisplayName("당첨 번호에 공백이 있으면 예외가 발생한다.")
    @Test
    void createWinngNumbersByBlack() {
        assertThatThrownBy(() -> new LottoMachine("1, 2", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 공백 없이 쉼표(,)로 구분된 숫자로만 입력해주세요.");
    }

    @DisplayName("당첨 번호가 쉼표를 제외하고 숫자가 아니면 예외가 발생한다.")
    @Test
    void createWinngNumbersByNotNumber() {
        assertThatThrownBy(() -> new LottoMachine("a,b,c", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 공백 없이 쉼표(,)로 구분된 숫자로만 입력해주세요.");
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinngNumbersByOverSize() {
        assertThatThrownBy(() -> new LottoMachine("1,2,3,4,5,6,7", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개 여야 합니다.");
    }

    @DisplayName("당첨 번호의 개수가 6개 보다 적으면 예외가 발생한다.")
    @Test
    void createWinngNumbersByUnderSize() {
        assertThatThrownBy(() -> new LottoMachine("1,2,3,4,5", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개 여야 합니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinngNumbersByDuplicateNumber() {
        assertThatThrownBy(() -> new LottoMachine("1,2,3,4,5,5", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
    }

    @DisplayName("당첨 번호의 숫자 범위가 1~45가 아닌 경우 예외가 발생한다.")
    @Test
    void createWinngNumbersByOverRange() {
        assertThatThrownBy(() -> new LottoMachine("1,2,3,4,5,46", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}