package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputProcessorTest {

    private InputProcessor inputProcessor;

    @BeforeEach
    void setUp() {
        inputProcessor = new InputProcessor();
    }

    @DisplayName("지불금액을 숫자로 변환하는 데 성공한다.")
    @Test
    void toPaidAmountSuccess() {
        Integer paidAmount = inputProcessor.toPaidAmount(" 4000 ");

        assertThat(paidAmount)
                .isEqualTo(4000);
    }

    @DisplayName("문자가 들어있어서 지불금액을 숫자로 변환하는 데 실패한다.")
    @Test
    void toPaidAmountFail() {
        assertThatThrownBy(() -> inputProcessor.toPaidAmount(",4000 "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호를 숫자로 변환하는 데 성공한다.")
    @Test
    void toWinningNumbersSuccess() {
        List<Integer> winningNumbers = inputProcessor.toWinningNumbers("1,2, 3,4,5,6 ");
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThat(winningNumbers)
                .isEqualTo(expectedNumbers);
    }

    @DisplayName("문자가 들어있어서 당첨번호를 숫자로 변환하는 데 실패한다.")
    @Test
    void toWinningNumbersFail() {
        assertThatThrownBy(() -> inputProcessor.toWinningNumbers("1,2, 3,4,5,b "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호를 숫자로 변환하는 데 성공한다.")
    @Test
    void toBonusNumberSuccess() {
        Integer bonusNumber = inputProcessor.toBonusNumber(" 17 ");

        assertThat(bonusNumber)
                .isEqualTo(17);
    }

    @DisplayName("문자가 들어있어서 보너스번호를 숫자로 변환하는 데 실패한다.")
    @Test
    void toBonusNumberFail() {
        assertThatThrownBy(() -> inputProcessor.toPaidAmount("a17 "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}