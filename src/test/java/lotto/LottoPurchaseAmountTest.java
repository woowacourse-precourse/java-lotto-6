package lotto;

import lotto.validator.ValidateBonusNumber;
import lotto.validator.ValidatePurchaseAmount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchaseAmountTest {

    @DisplayName("로또 구입금액 입력 시 금액의 값이 1000원 이하이면 예외 발생.")
    @Test
    void validateSmallThanThousand(){
        String input="900";
        assertThatThrownBy(()-> ValidatePurchaseAmount.validatePurchaseAmount(input))
                .hasMessage("[ERROR] 로또의 한장 가격은 1000원 입니다.");
    }

    @DisplayName("로또 구입금액 입력 시 금액의 값이 1000원으로 나뉘어지지 않을 때 예외 발생.")
    @Test
    void validateDividableThousand(){
        String input="1100";
        assertThatThrownBy(()->ValidatePurchaseAmount.validatePurchaseAmount(input))
                .hasMessage("[ERROR] 로또의 한장 가격은 1000원 입니다. 1000원 단위로 입력하십시오.");
    }

    @DisplayName("로또 구입금액 입력값 받을 때 값이 비어있으면 예외가 발생한다.")
    @Test
    void validateEmpty(){
        String input="";
        assertThatThrownBy(()-> ValidatePurchaseAmount.validatePurchaseAmount(input))
                .hasMessage("[ERROR] 값을 입력해주세요.");
    }

    @DisplayName("로또 보너스 번호 입력값이 숫자가 아닌 값일 때 예외 발생.")
    @Test
    void validateConvertable(){
        String input="a";
        assertThatThrownBy(()->ValidatePurchaseAmount.validatePurchaseAmount(input))
                .hasMessage("[ERROR] 숫자를 입력해주세요.");
    }

}
