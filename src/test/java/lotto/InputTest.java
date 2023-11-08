package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static lotto.Input.*;

public class InputTest {
    @DisplayName("구매 금액 입력이 올바른지 확인")
    @Test
    void validateInputTest(){
        int validateInput = validateInput("1000");
        Assertions.assertThat(validateInput).isEqualTo(1000);
        Assertions.assertThatThrownBy(() -> validateInput("100r4")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validateInput("1001")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 올바른지 확인")
    @Test
    void validatePrizeInputTest(){
        String prizeNumber = validatePrizeInput("1,2,3,4,5,6");
        Assertions.assertThat(prizeNumber).isEqualTo("1,2,3,4,5,6");
        Assertions.assertThatThrownBy(() -> validatePrizeInput("1,2,3,4,5,5")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validatePrizeInput("1,2,3,4,5,46")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validatePrizeInput("1,2,3,4,5r")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validatePrizeInput("1,2,3,,5")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 올바른지 확인")
    @Test
    void validateBonusInputTest(){
        ArrayList<Integer> prizeNumberArray = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        Assertions.assertThatThrownBy(() -> validateBonusInput("6", prizeNumberArray)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validateBonusInput("5r", prizeNumberArray)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validateBonusInput("47", prizeNumberArray)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> validateBonusInput("", prizeNumberArray)).isInstanceOf(IllegalArgumentException.class);
    }
}
