package lotto.ValidateTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.input.view.input.LottoWinningNumberInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberInputTest {

    LottoWinningNumberInput inputView = new LottoWinningNumberInput();

    @Test
    @DisplayName("당첨 번호 개수 확인 테스트 : 6개의 당첨 번호 확인 ")
    void sizeValidateTest() {
        List<String> input = inputView.splitInput("1,2,3,4,5");
        assertThat(input.size()).isEqualTo(5);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                inputView.valueSizeValidate(input));
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트 : 숫자가 아닌 값 입력")
    void isNumberValidateTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                inputView.isNumberValidate("aaa"));
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트 : 1~45 사이 숫자 입력")
    void scopeValidateTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                inputView.scopeValidate(100));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                inputView.scopeValidate(0));
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트 : 1~45 사이 숫자 입력")
    void isDuplicateValidateTest() {
        Assertions.assertDoesNotThrow(() ->
                inputView.isDuplicateValidate(1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputView.isDuplicateValidate(1));
    }

}
