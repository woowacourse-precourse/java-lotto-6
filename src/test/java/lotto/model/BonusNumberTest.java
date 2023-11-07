package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    // 범위 관련 테스트
    @DisplayName("보너스 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    void createBonusNumberByOutOfRange(int bonusNumber) {
        assertThatThrownBy(() -> new BonusNumber(bonusNumber, new WinningNumber(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.OUT_OF_RANGE_NUMBER_EXCEPTION.getMessage());
    }

    @DisplayName("보너스 번호가 1 ~ 45 사이의 숫자이면 보너스 번호가 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {7, 45, 23})
    void createBonusNumberByInRange(int bonusNumber) {
        BonusNumber bonusNumberObject = new BonusNumber(bonusNumber, new WinningNumber(List.of(1, 2, 3, 4, 5, 6)));
        Assertions.assertThat(bonusNumberObject).isNotNull();
    }

    // 중복 관련 테스트
    @DisplayName("보너스 번호가 당첨 번호에 포함되면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicateBonusNumber() {
        Assertions.assertThatThrownBy(() -> new BonusNumber(1, new WinningNumber(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_BONUS_NUMBER_EXCEPTION.getMessage());

        Assertions.assertThatThrownBy(() -> new BonusNumber(45, new WinningNumber(List.of(1, 2, 3, 4, 5, 45))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_BONUS_NUMBER_EXCEPTION.getMessage());
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되지 않으면 당첨 로또가 생성된다.")
    @Test
    void createWinningLotto() {
        BonusNumber bonusNumber = new BonusNumber(7, new WinningNumber(List.of(1, 2, 3, 4, 5, 6)));
        Assertions.assertThat(bonusNumber).isNotNull();
    }
}
