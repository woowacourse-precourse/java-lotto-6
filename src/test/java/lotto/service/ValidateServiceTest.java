package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constant.ErrorConstant.ERROR_PREFIX;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ValidateServiceTest {

    ValidateService validateService = new ValidateService();

    @Test
    @DisplayName("구매 금액 입력 - 실패(숫자 X)")
    public void inputPurchaseMoneyIsNotDigit() throws Exception {
        //given
        String inputPurchaseMoney = "woo0doo";

        //when - then
        assertThatThrownBy(() -> validateService.validateInputPurchaseMoney(inputPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_PREFIX + "숫자로 이루어져야 합니다.");
    }

    @Test
    @DisplayName("구매 금액 입력 - 실패(1000단위가 아님)")
    public void inputPurchaseMoneyCanNotDivideThousand() throws Exception {
        //given
        String inputPurchaseMoney = "4001";

        //when - then
        assertThatThrownBy(() -> validateService.validateInputPurchaseMoney(inputPurchaseMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_PREFIX + "구매금액은 1000단위로 입력해야 합니다.");
    }

    @Test
    @DisplayName("당첨 금액 입력 - 실패(형식에 맞지 않음)")
    public void inputWinnerNumberIsWrongType() throws Exception {
        //given
        String inputWinnerNumber = "1,2,3,4,5,six";

        //when - then
        assertThatThrownBy(() -> validateService.validateInputWinnerNumber(inputWinnerNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_PREFIX + "형식에 맞게 입력해 주세요. ex) 1,2,3,4,5,6");
    }

    @Test
    @DisplayName("당첨 금액 입력 - 실패(숫자 6개가 아님)")
    public void inputWinnerNumberIsNotCorrectSize() throws Exception {
        //given
        String inputWinnerNumber = "1,2,3,4,5";

        //when - then
        assertThatThrownBy(() -> validateService.validateInputWinnerNumber(inputWinnerNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_PREFIX + "숫자 6개를 입력해 주세요.");
    }

    @Test
    @DisplayName("당첨 금액 입력 - 실패(범위가 틀림)")
    public void inputWinnerNumberIsNotCorrectRange() throws Exception {
        //given
        String inputWinnerNumber = "1,2,3,4,5,50";

        //when - then
        assertThatThrownBy(() -> validateService.validateInputWinnerNumber(inputWinnerNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_PREFIX + "1~45 사이의 값을 입력해 주세요.");
    }

    @Test
    @DisplayName("당첨 금액 입력 - 실패(범위가 틀림)")
    public void inputWinnerNumberIsDuplicateNumber() throws Exception {
        //given
        String inputWinnerNumber = "1,2,3,4,5,5";

        //when - then
        assertThatThrownBy(() -> validateService.validateInputWinnerNumber(inputWinnerNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_PREFIX + "중복 되지 않는 값을 입력해 주세요.");
    }


}
