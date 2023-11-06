package lotto;

import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {
    InputView inputView = new InputView();

    /**
     * 구매 금액 관련
     */
    @DisplayName("로또 구매 금액 숫자인지 테스트")
    @Test
    public void validatePurchaseMoneyIsIntTest() throws Exception {
        // given
        String inputStr = "저는 스트링 입니다";

        // when, then
        assertThatThrownBy(() -> inputView.validatePurchaseMoneyIsInt(inputStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액 1000원 단위인지 테스트")
    @Test
    public void validatePurchaseMoneyIsMultipleOfThousandTest() throws Exception {
        // given
        int inputInt = 1577;

        // when, then
        assertThatThrownBy(() -> inputView.validatePurchaseMoneyIsMultipleOfThousand(inputInt))
                .isInstanceOf(IllegalArgumentException.class);
    }


    /**
     * 당첨 번호 관련
     */

    @DisplayName("당첨 번호의 개수 확인")
    @Test
    public void validateWinningNumCountIsOverTest() throws Exception {
        // given
        ArrayList<Integer> winningNum = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));

        // when, then
        assertThatThrownBy(() -> inputView.validateWinningNumCountIsOver(winningNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력이 콤마가 연속으로 등장할 때")
    @Test
    public void validateWinningNumCommaAfterCommaTest() throws Exception {
        // given
        String winningNumStr = "1,2,3,4,5,,6";

        // when, then
        assertThatThrownBy(() -> inputView.validateWinningNumCommaAfterComma(winningNumStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력사이에 공백이 존재할 때")
    @Test
    public void validateBlankInWinningNumTest() throws Exception {
        // given
        String winningNumStr = "1,2,3,4,5, ,6";

        // when, then
        assertThatThrownBy(() -> inputView.validateBlankInWinningNum(winningNumStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 마지막 글자가 , 일때")
    @Test
    public void validateWinningNumLastCharIsCommaTest() throws Exception {
        // given
        String winningNumStr = "1,2,3,4,5,6,";

        // when, then
        assertThatThrownBy(() -> inputView.validateWinningNumLastCharIsComma(winningNumStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * 보너스 숫자 관련
     */

    @DisplayName("보너스 숫자 int인지 테스트")
    @Test
    public void validateBonusNumIsIntTest() throws Exception {
        // given
        String inputStr = "저는 스트링 입니다";

        // when, then
        assertThatThrownBy(() -> inputView.validateBonusNumIsInt(inputStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 1~45 사이의 숫자인지 테스트")
    @Test
    public void validateBonusNumIsInRangeTest() throws Exception {
        // given
        int bonusNum = 100;

        // when, then
        assertThatThrownBy(() -> inputView.validateBonusNumIsInRange(bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
