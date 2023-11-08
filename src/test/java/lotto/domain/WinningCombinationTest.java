package lotto.domain;

import lotto.view.message.exception.WinningCombinationInputErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningCombinationTest {
    private static final String inputWinningNumbers = "1,2,3,4,5,6";

    @DisplayName("이미 winningNumbers의 검증이 완료가 되었다고 가정 \n 입력된 보너스 넘버가 당첨 번호와 중복일 때 예외 발생")
    @Test
    void createCheckDuplicateWinningCombination(){
        BonusNumber inputBonusNumber = new BonusNumber(6);
        assertThatThrownBy(() -> new WinningCombination(new WinningLottoNumbers(inputWinningNumbers),inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.DUPLICATED_NUMBER.getMessage());
    }
}