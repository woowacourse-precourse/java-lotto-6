package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.Application.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SetLottoAnswerTest {

    @DisplayName("당첨번호 입력 시 숫자가 아닌 값을 넣었을 때, 예외가 발생한다.")
    @Test
    void setLottoAnswerByNonNumericFormatException() {
        assertThatThrownBy(() -> setLottoAnswer("1,2,3,4,5,6z"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력 시 1~45 사이가 아닌 숫자 입력 시, 예외가 발생한다.")
    @Test
    void setLottoAnswerByNonRangeException() {
        assertThatThrownBy(() -> setLottoAnswer("1,2,3,4,5,0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력 시 이미 입력한 당첨번호를 재입력할 경우, 예외가 발생한다.")
    @Test
    void setLottoAnswerByDuplicateAnswerInput() {
        assertThatThrownBy(() -> setLottoAnswer("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력 시 6개의 숫자가 아닌 값들을 입력할 경우, 예외가 발생한다.[6개보다 큰 입력갯수]")
    @Test
    void setLottoAnswerByNotFormattedInputOverSize() {
        assertThatThrownBy(() -> setLottoAnswer("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력 시 6개의 숫자가 아닌 값들을 입력할 경우, 예외가 발생한다. [6개보다 작은 입력갯수]")
    @Test
    void setLottoAnswerByNotFormattedInputUnderSize() {
        assertThatThrownBy(() -> setLottoAnswer("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("보너스 번호 입력 시 숫자가 아닌 값을 넣었을 때, 예외가 발생한다.")
    @Test
    void setBonusNumberByNonNumericFormatException() {
        assertThatThrownBy(() -> setBonusNumber("45z"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 시 0~45가 아닌 수를 넣었을 때, 예외가 발생한다.")
    @Test
    void setBonusNumberByNonRangeException() {
        assertThatThrownBy(() -> setBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 시 당첨 번호에 있는 수가 중복될 경우, 예외가 발생한다.")
    @Test
    void setBonusNumberByDuplicateInAnswer() {
        Application.lottoAnswer = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> validateBonusNumberIsInAnswer(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
