package lotto;

import lotto.validator.PrizeNumbersValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeNumbersValidatorTest {
    @DisplayName("당첨 번호 입력 시 아무 입력도 하지 않으면 예외가 발생한다.")
    @Test
    void setPrizeNumbersByNull1() {
        assertThatThrownBy(() -> new PrizeNumbersValidator().validate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 시 아무 입력도 하지 않으면 예외가 발생한다.")
    @Test
    void setPrizeNumbersByNull2() {
        assertThatThrownBy(() -> new PrizeNumbersValidator().validate(",,,,,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 시 공백을 입력하면 예외가 발생한다.")
    @Test
    void setPrizeNumbersByBlank1() {
        assertThatThrownBy(() -> new PrizeNumbersValidator().validate(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 시 공백을 입력하면 예외가 발생한다.")
    @Test
    void setPrizeNumbersByBlank2() {
        assertThatThrownBy(() -> new PrizeNumbersValidator().validate(" , , , , , "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력 시 숫자 외 문자를 입력하면 예외가 발생한다.")
    @Test
    void setPrizeNumbersByString() {
        assertThatThrownBy(() -> new PrizeNumbersValidator().validate("1,2,3,4,5,six"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void setPrizeNumbersByOverSize() {
        assertThatThrownBy(() -> new PrizeNumbersValidator().validate("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개 미만 이면 예외가 발생한다.")
    @Test
    void setPrizeNumbersByUnderSize() {
        assertThatThrownBy(() -> new PrizeNumbersValidator().validate("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
