package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    List<Integer> winningNumber;

    @BeforeEach
    void setup() {
        winningNumber = List.of(1,2,3,4,5,6);
    }
    @Test
    @DisplayName("보너스 번호를 생성한다.")
    void createBonusNumberOf() {
        String bonusNum = "7";
        BonusNumber bonusNumber = BonusNumber.bonusNumberOf(winningNumber,bonusNum);
        assertEquals(bonusNumber.getBonusNumber(),7);
    }
    @Test
    @DisplayName("보너스 번호가 1부터 45사이의 숫자가 아니라면 예외를 발생한다.")
    void exceptionByOutOfRangeBonusNumber(){
        String bonusNum = "47";
        assertThatThrownBy(() -> BonusNumber.bonusNumberOf(winningNumber,bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    @Test
    @DisplayName("보너스 번호가 1부터 45사이의 숫자가 아니라면 예외를 발생한다.")
    void exceptionByDuplicateBonusNumberWithWinningNumber(){
        String bonusNum = "1";
        assertThatThrownBy(() -> BonusNumber.bonusNumberOf(winningNumber,bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 번호가 있습니다.");
    }
}