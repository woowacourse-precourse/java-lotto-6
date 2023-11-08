package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import lotto.global.Validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {


    @DisplayName("금액이 1000의 배수가 아니라면 예외를 발생한다.")
    @Test
    void undevidedNumberByThousand() {
        assertThatThrownBy(() -> Validator.checkAmount(1001)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 당첨 번호와 중복된다면 예외를 발생한다.")
    @Test
    void duplicatedBonusNumberWithWinningNumber() {
        assertThatThrownBy(() -> Validator.checkBonusNumber(3, List.of(1, 2, 3, 4, 5, 6))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자가 범위를 벗어난다면 예외를 발생한다.")
    @Test
    void outRangedBonusNumberWithWinningNumber() {
        assertThatThrownBy(() -> Validator.checkBonusNumber(1000, List.of(1, 2, 3, 4, 5, 6))).isInstanceOf(IllegalArgumentException.class);
    }

}
