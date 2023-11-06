package lotto.domain;

import lotto.view.message.exception.WinningCombinationInputErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningCombinationTest {
    private static final String inputWinningNumbers = "1,2,3,4,5,6";
    @DisplayName("이미 winningNumbers의 검증이 완료가 되었다고 가정 \n 입력된 보너스 넘버가 로또 번호 범위를 벗어났을 때 예외 발생")
    @Test
    void outOfRangeBonusNumber() {
        int inputBonusNumber=46;
        assertThatThrownBy(() -> new WinningCombination(new WinningLottoNumbers(inputWinningNumbers),inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
    }

    @DisplayName("이미 winningNumbers의 검증이 완료가 되었다고 가정 \n 입력된 보너스 넘버가 당첨 번호와 중복일 때 예외 발생")
    @Test
    void isDuplicateBonusNumber(){
        int inputBonusNumber=6;
        assertThatThrownBy(() -> new WinningCombination(new WinningLottoNumbers(inputWinningNumbers),inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.DUPLICATED_NUMBER.getMessage());
    }
}