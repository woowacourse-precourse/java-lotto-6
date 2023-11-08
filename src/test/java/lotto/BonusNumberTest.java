package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @DisplayName("보너스 번호가 정상적으로 생성된다.")
    @Test
    void createBonusNumberByCorrectNumber() {
        assertDoesNotThrow(() -> new BonusNumber("9", List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("보너스 번호가 정답이랑 중복될 경우 예외 발생")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new BonusNumber("1", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATED_BONUS.getMessage());
    }

    @DisplayName("보너스 번호가 음수일 경우 예외 발생")
    @Test
    void createBonusNumberByNegativeNumber() {
        assertThatThrownBy(() -> new BonusNumber("-1", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.IS_NEGATIVE.getMessage());
    }

    @DisplayName("보너스 번호가 문자일 경우 예외 발생")
    @Test
    void createBonusNumberByNonNumber() {
        assertThatThrownBy(() -> new BonusNumber("d", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WRONG_TYPE.getMessage());
    }

    @DisplayName("보너스 번호가 소수일 경우 예외 발생")
    @Test
    void createBonusNumberByDecimal() {
        assertThatThrownBy(() -> new BonusNumber("1.1", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WRONG_TYPE.getMessage());
    }

    @DisplayName("보너스 번호가 범위 밖일 경우 예외 발생")
    @Test
    void createBonusNumberByOutRangeNumber() {
        assertThatThrownBy(() -> new BonusNumber("100", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.OUT_OF_RANGE.getMessage());
    }

}
