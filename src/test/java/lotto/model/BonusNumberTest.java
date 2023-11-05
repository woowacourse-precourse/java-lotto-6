package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "45"})
    @DisplayName("보너스 번호 저장 값 검증")
    public void 보너스_번호_값(String input){
        BonusNumber bonusNumber = new BonusNumber(input);

        String myResult = bonusNumber.getBonusNumber();
        assertEquals(myResult, input);
    }
    @ParameterizedTest
    @ValueSource(strings = {"*/-/","hi2"})
    @DisplayName("[예외처리] 보너스 숫자 입력이 숫자가 아닐 때")
    public void 보너스_입력(String input){
        String bonusNumber = input;
        Assertions.assertThatThrownBy(()-> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상 45이하");
    }
    @ParameterizedTest
    @ValueSource(strings = {"0", "88"})
    @DisplayName("[예외처리] 보너스 숫자 입력이 범위를 벗어날 때")
    public void 보너스_입력_범위(String input){
        String bonusNumber = input;
        Assertions.assertThatThrownBy(()-> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상 45이하");
    }
}
