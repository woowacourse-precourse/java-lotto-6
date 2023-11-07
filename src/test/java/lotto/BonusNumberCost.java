package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.PurchaseCost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberCost {
    @DisplayName("보너스 번호 입력 기능이 잘 작동하는가?")
    @Test
    void test1(){
        BonusNumber bonusNumber = new BonusNumber("3");
        Assertions.assertEquals(bonusNumber.getNumber(), 3);
    }


    @DisplayName("숫자가 아닌 경우 예외 발생")
    @Test
    void test2(){
        BonusNumber bonusNumber = new BonusNumber("3");
        assertThatThrownBy(() -> bonusNumber.validateNumber("asf"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("보너스 번호의 숫자가 1~45 범위를 벗어날 경우 예외 발생")
    @Test
    void test3(){
        BonusNumber bonusNumber = new BonusNumber("3");
        assertThatThrownBy(() -> bonusNumber.validateRange("-24"))
                .isInstanceOf(IllegalArgumentException.class);
    }




}
