package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    
    @DisplayName("쉼표(,)로 구분하여 6개가 아니면 예외가 발생한다.")
    @Test
    void createWinningNumbersByOverSize() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6,7,8"))
                    .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("쉼표(,)로 구분했을 때 하나라도 0자이면 예외가 발생한다.")
    @Test
    void createWinningNumbersByIncludingEmpty() {
        assertThatThrownBy(() -> new WinningNumbers("1,,3,4,5,6"))
                    .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("쉼표(,)로 구분했을 때 하나라도 수가 아니면 예외가 발생한다.")
    @Test
    void createWinningNumbersByIncludingNotNumber() {
        assertThatThrownBy(() -> new WinningNumbers("1,나,3,4,5,6"))
                    .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("범위 밖의 수를 입력하면 예외가 발생한다.")
    @Test
    void createWinningNumbersByOutOfRange() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,77"))
                    .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("6개의 수중 중복이 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,5"))
                    .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("보너스 번호의 입력이 0자이면 예외가 발생한다.")
    @Test
    void setBonusNumberEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
            winningNumbers.setBonusNumber("");
        });
    }
    
    @DisplayName("보너스 번호의 입력에 수가 아닌 입력을 하면 예외가 발생한다.")
    @Test
    void setBonusNumberNotNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
            winningNumbers.setBonusNumber("가");
        });
    }
    
    @DisplayName("보너스 번호의 입력에 범위에 해당하지 않는 수를 입력하면 예외가 발생한다.")
    @Test
    void setBonusNumberOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
            winningNumbers.setBonusNumber("99");
        });
    }
    
    @DisplayName("보너스 번호의 입력에 기존 당첨 번호와 중복이 있으면 예외가 발생한다.")
    @Test
    void setBonusNumberInWinningLotto() {
        assertThrows(IllegalArgumentException.class, () -> {
            WinningNumbers winningNumbers = new WinningNumbers("21,31,33,36,39,44");
            winningNumbers.setBonusNumber("21");
        });
    }
}
